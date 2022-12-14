package de.ytendx.mccloud.common.minio;

import io.minio.*;
import io.minio.errors.*;
import io.minio.messages.Item;

import java.io.File;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Stream;

public class MinIOProvider {

    public static final String BUCKET_NAME = "unclouded-cloud";

    private final MinioClient client;

    public MinIOProvider(String endpoint, String accessKey, String secretKey) {
        this.client = MinioClient.builder()
                .endpoint(endpoint)
                .credentials(accessKey, secretKey)
                .build();
    }

    public List<Item> fetchAllItems() {
        var itemList = new CopyOnWriteArrayList<Item>();

        this.client.listObjects(
                ListObjectsArgs.builder()
                        .bucket(BUCKET_NAME)
                        .build()
        ).forEach(itemResult -> {
            try {
                itemList.add(itemResult.get());
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        });

        return itemList;
    }

    /**
     * Downloads specific items from a list to a certain folder given
     *
     * @param items - Items to be downloaded
     * @param path - Path of the folder that the items will be downloaded to (Needs to exist otherwise it will not work)
     */
    public void downloadItems(List<Item> items, String path){
        var directory = new File(path);

        if (!directory.exists()) {
            // TODO: Build in warning
        }

        for (var item : items) {
            try {
                client.downloadObject(DownloadObjectArgs.builder()
                        .bucket(BUCKET_NAME)
                        .overwrite(true)
                        .filename(path + "/" + item.objectName())
                        .object(item.objectName())
                        .build()
                );
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
    }

    public MinioClient getClient() {
        return client;
    }


}
