package edu.najah.cap.data.exportdatafeature.processdata.impl;

import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;
import edu.najah.cap.data.exportdatafeature.processdata.intf.IActionable;
import java.io.*;

public class UploadToStorage implements IActionable {
    private static final String accessToken = "sl.Bst5pt2LYhuEEQf154WY8JcAEUqXD2lBeO_oOACECyqPICyG-vf1wU4xK8lSERL7X3dmQK-6Al2c3FmzE__nxZM70zb2IL9AcfIVLTqtqM2XWvEVoMp0smie04sjRHI9aBnPMn5ttonoAm8mNpgAlhw";
    private static final String appName = "advance-software";

    @Override
    public void actionProcess(byte[] data, String fileName) throws IOException, DbxException {
        uploadToDropbox(data, fileName);
    }

    private void uploadToDropbox(byte[] fileContent, String fileName) throws DbxException, IOException {
        DbxRequestConfig config = new DbxRequestConfig(appName);
        try (InputStream in = new ByteArrayInputStream(fileContent)) {
            DbxClientV2 client = new DbxClientV2(config, accessToken);
            FileMetadata metadata = client.files().uploadBuilder("/" + fileName + ".zip")
                    .uploadAndFinish(in);
            System.out.println("File uploaded to Dropbox : " + metadata.getName() + ", have a good day \uD83D\uDC9A. ");
        }
    }
}
