package edu.najah.cap.data.exportdatafeature.converter;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.*;

import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ConvertString {
    public byte[] convertTextToPDF(String data) {
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
            Document document = new Document();
            PdfWriter.getInstance(document, byteArrayOutputStream);
            document.open();
            String[] lines = data.split("\n");
            for (String line : lines) {
                document.add(new Paragraph(line));
            }
            document.close();
            return byteArrayOutputStream.toByteArray();
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
            return new byte[]{};
        }
    }

    public byte[] convertPDFToZip(byte[] pdfData) {
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
             ZipOutputStream zipOutputStream = new ZipOutputStream(byteArrayOutputStream)) {

            ZipEntry zipEntry = new ZipEntry("document.pdf");
            zipOutputStream.putNextEntry(zipEntry);
            zipOutputStream.write(pdfData);
            zipOutputStream.closeEntry();
            zipOutputStream.finish();

            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            return new byte[]{};
        }
    }

    public byte[] convertPDFsToZip(byte[] pdfData1, byte[] pdfData2) {
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
             ZipOutputStream zipOutputStream = new ZipOutputStream(byteArrayOutputStream)) {

            addFileToZip("document1.pdf", pdfData1, zipOutputStream);
            addFileToZip("document2.pdf", pdfData2, zipOutputStream);

            zipOutputStream.finish();

            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            return new byte[]{};
        }
    }

    private void addFileToZip(String fileName, byte[] fileData, ZipOutputStream zipOutputStream) throws IOException {
        ZipEntry zipEntry = new ZipEntry(fileName);
        zipOutputStream.putNextEntry(zipEntry);
        zipOutputStream.write(fileData);
        zipOutputStream.closeEntry();
    }
}