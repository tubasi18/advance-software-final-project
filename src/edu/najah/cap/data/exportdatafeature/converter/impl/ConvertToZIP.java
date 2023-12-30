package edu.najah.cap.data.exportdatafeature.converter.impl;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import edu.najah.cap.data.exportdatafeature.converter.intf.IConverter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ConvertToZIP implements IConverter {
    @Override
    public byte[] convert(List<String> pdfDataList) {
        String[] nameOfFiles = {"User_Details","Payment_Details"};
        try (ByteArrayOutputStream zipByteArrayOutputStream = new ByteArrayOutputStream();
             ZipOutputStream zipOutputStream = new ZipOutputStream(zipByteArrayOutputStream)) {
            for (int i = 0; i < pdfDataList.size(); i++) {
                String pdfData = pdfDataList.get(i);
                ByteArrayOutputStream pdfOutputStream = new ByteArrayOutputStream();
                Document document = new Document();
                PdfWriter.getInstance(document, pdfOutputStream);
                document.open();
                String[] lines = pdfData.split("\n");
                for (String line : lines) {
                    document.add(new Paragraph(line));
                }
                document.close();
                ZipEntry zipEntry = new ZipEntry(nameOfFiles[i]  + ".pdf");
                zipOutputStream.putNextEntry(zipEntry);
                zipOutputStream.write(pdfOutputStream.toByteArray());
                zipOutputStream.closeEntry();
            }
            zipOutputStream.finish();
            return zipByteArrayOutputStream.toByteArray();
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
            return new byte[]{};
        }
    }
}



