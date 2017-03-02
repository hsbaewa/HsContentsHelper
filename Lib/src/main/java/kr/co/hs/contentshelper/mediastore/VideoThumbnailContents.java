package kr.co.hs.contentshelper.mediastore;

import android.database.Cursor;
import android.provider.MediaStore;

/**
 * 생성된 시간 2017-03-02, Bae 에 의해 생성됨
 * 프로젝트 이름 : HsContentsHelper
 * 패키지명 : kr.co.hs.contentshelper.mediastore
 */

public class VideoThumbnailContents extends ThumbnailContents {
    public VideoThumbnailContents(Cursor cursor) {
        super(
                cursor.getLong(cursor.getColumnIndex(MediaStore.Video.Thumbnails._ID)),
                cursor.getString(cursor.getColumnIndex(MediaStore.Video.Thumbnails.DATA))
        );
    }

    public VideoThumbnailContents(long id) {
        super(id);
    }

    public VideoThumbnailContents(long id, String path) {
        super(id, path);
    }
}
