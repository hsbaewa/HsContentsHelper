package kr.co.hs.contentshelper.mediastore;

import android.content.Context;

/**
 * 생성된 시간 2017-03-02, Bae 에 의해 생성됨
 * 프로젝트 이름 : HsContentsHelper
 * 패키지명 : kr.co.hs.contentshelper.mediastore
 */

abstract class ThumbnailProvider<C extends ThumbnailContents> extends Provider<C> {
    public ThumbnailProvider(Context context, int mode) {
        super(context, mode);
    }

    public abstract C getThumbnailFromMediaId(long mediaId);
}
