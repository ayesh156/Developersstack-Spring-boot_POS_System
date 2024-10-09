package com.pos.system.service.impl;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.pos.system.entity.ApplicationUser;
import com.pos.system.entity.Batch;
import com.pos.system.exceptions.EntryNotFoundException;
import com.pos.system.jwt.JwtAuthenticationFilter;
import com.pos.system.jwt.TokenExtractor;
import com.pos.system.repository.ApplicationUserRepo;
import com.pos.system.repository.BatchRepo;
import com.pos.system.service.BatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.sql.rowset.serial.SerialBlob;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Date;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BatchServiceImpl implements BatchService {

    private final BatchRepo batchRepo;
    private final TokenExtractor tokenExtractor;
    private final ApplicationUserRepo userRepo;
    @Override
    public void create(String token) throws SQLException, IOException, WriterException {
        String subject = tokenExtractor.getSubject(token);
        Optional<ApplicationUser> byUsername = userRepo.findByUsername(subject);
        if(byUsername.isEmpty()){
            throw new EntryNotFoundException("email not found");
        }

        UUID batchId = UUID.randomUUID();
        long l = new Random().nextLong();

        Batch build = Batch.builder()
                .batchId(batchId.toString())
                .createdBy(byUsername.get())
                .batchNumber(l)
                .createdDate(new Date())
                .barcode(generateImg(new String(String.valueOf(l)), 100, 100))
                .build();
        batchRepo.save(build);
    }

    private Blob generateImg(String text, int width, int height) throws WriterException, IOException, SQLException {
        BitMatrix bitMatrix = new MultiFormatWriter().encode(text, BarcodeFormat.CODE_128, width, height);
        BufferedImage bufferedImage = MatrixToImageWriter.toBufferedImage(bitMatrix);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix,"png",byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();

        return new SerialBlob(byteArray);

    }

}
