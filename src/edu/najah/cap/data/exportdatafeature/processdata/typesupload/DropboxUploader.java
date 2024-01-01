package edu.najah.cap.data.exportdatafeature.processdata.typesupload;

import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;
import com.dropbox.core.v2.sharing.SharedLinkMetadata;
import edu.najah.cap.data.exportdatafeature.processdata.intf.IUploadService;
import edu.najah.cap.exceptions.InvalidUploadTypeException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class DropboxUploader implements IUploadService {
    private static final String accessToken = "sl.BsvIG3NLGt8kmHWeFfDyBJG5yMCahm32y37a1xCxWU6eiu3MXwhTfCrQW-SOhcBEpDlzk_LegMdcqhtnY1bYBAU69XyeRQC3mkHJvnOvtVX3K0OQWRfuhtLAsTa5xF0gAhFACDujOEziRyiQPmAMkoo";
    private static final String appName = "advance-software";
    private static final Logger logger = LogManager.getLogger(DropboxUploader.class);

    @Override
    public void upload(byte[] fileContent, String fileName) throws InvalidUploadTypeException {
        DbxRequestConfig config = new DbxRequestConfig(appName);
        try (InputStream in = new ByteArrayInputStream(fileContent)) {
            DbxClientV2 client = new DbxClientV2(config, accessToken);
            FileMetadata metadata = client.files().uploadBuilder("/" + fileName + ".zip")
                    .uploadAndFinish(in);
            SharedLinkMetadata sharedLinkMetadata = client.sharing().createSharedLinkWithSettings("/" + fileName + ".zip");
            String sharedLink = sharedLinkMetadata.getUrl();

            System.out.println("File uploaded to Dropbox: " + metadata.getName() +
                    ", Shareable link: " + sharedLink +
                    ", have a good day \uD83D\uDC9A.");
            logger.info(String.format("Upload file into  Dropbox : %s, name file: %s", metadata.getName(), fileName));
        } catch (IOException | DbxException e) {
            logger.error(String.format("Error in upload dropbox %s", e.getMessage()));
            throw new InvalidUploadTypeException("Error in upload dropbox : " + e.getMessage());
        }
    }
}