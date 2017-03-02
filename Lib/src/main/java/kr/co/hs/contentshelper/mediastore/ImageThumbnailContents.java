package kr.co.hs.contentshelper.mediastore;

import android.database.Cursor;
import android.provider.MediaStore;

/**
 * 생성된 시간 2017-03-02, Bae 에 의해 생성됨
 * 프로젝트 이름 : HsContentsHelper
 * 패키지명 : kr.co.hs.contentshelper.mediastore
 */

public class ImageThumbnailContents extends ThumbnailContents {
    public ImageThumbnailContents(Cursor cursor) {
        super(
                cursor.getLong(cursor.getColumnIndex(MediaStore.Images.Thumbnails._ID)),
                cursor.getString(cursor.getColumnIndex(MediaStore.Images.Thumbnails.DATA))
                );
    }

    public ImageThumbnailContents(long id) {
        super(id);
    }

    public ImageThumbnailContents(long id, String path) {
        super(id, path);
    }
}
