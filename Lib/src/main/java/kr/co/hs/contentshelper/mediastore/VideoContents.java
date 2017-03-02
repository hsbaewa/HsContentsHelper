package kr.co.hs.contentshelper.mediastore;

import android.provider.MediaStore;

/**
 * 생성된 시간 2017-03-02, Bae 에 의해 생성됨
 * 프로젝트 이름 : HsContentsHelper
 * 패키지명 : kr.co.hs.contentshelper.mediastore
 */

public class VideoContents extends MediaContents {
    private long mTakenDate = 0;

    public VideoContents(long id) {
        super(id);
    }

    public VideoContents(long id, String dataPath, long addedDate, long modifiedDate, long takenDate) {
        super(id, dataPath, addedDate, modifiedDate);
        mTakenDate = takenDate;
    }

    public long getTakenDate() {
        return mTakenDate;
    }
}
