package kr.co.hs.contentshelper.mediastore;

import android.content.Context;
import android.provider.MediaStore;

/**
 * 생성된 시간 2017-03-02, Bae 에 의해 생성됨
 * 프로젝트 이름 : HsContentsHelper
 * 패키지명 : kr.co.hs.contentshelper.mediastore
 */

public class ImageProviderCursor extends ProviderCursor<ImageContents> {
    public ImageProviderCursor(Context context) {
        super(context, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
    }

    public ImageProviderCursor(Context context, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        super(context, MediaStore.Images.Media.EXTERNAL_CONTENT_URI, projection, selection, selectionArgs, sortOrder);
    }

    @Override
    public ImageContents getContent(int position) {
        getCursor().moveToPosition(position);
        return new ImageContents(getCursor());
    }
}
