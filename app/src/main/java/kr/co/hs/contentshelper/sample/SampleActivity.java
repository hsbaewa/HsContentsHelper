package kr.co.hs.contentshelper.sample;

import android.Manifest;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import kr.co.hs.app.HsActivity;
import kr.co.hs.app.OnRequestPermissionResult;
import kr.co.hs.content.HsPermissionChecker;
import kr.co.hs.contentshelper.mediastore.AudioArtContents;
import kr.co.hs.contentshelper.mediastore.AudioArtProvider;
import kr.co.hs.contentshelper.mediastore.AudioContents;
import kr.co.hs.contentshelper.mediastore.AudioProvider;
import kr.co.hs.contentshelper.mediastore.ImageContents;
import kr.co.hs.contentshelper.mediastore.ImageProvider;
import kr.co.hs.contentshelper.mediastore.ImageThumbnailContents;
import kr.co.hs.contentshelper.mediastore.ImageThumbnailProvider;
import kr.co.hs.contentshelper.mediastore.VideoContents;
import kr.co.hs.contentshelper.mediastore.VideoProvider;
import kr.co.hs.contentshelper.mediastore.VideoThumbnailContents;
import kr.co.hs.contentshelper.mediastore.VideoThumbnailProvider;

/**
 * 생성된 시간 2017-03-02, Bae 에 의해 생성됨
 * 프로젝트 이름 : HsContentsHelper
 * 패키지명 : kr.co.hs.contentshelper.sample
 */

public class SampleActivity extends HsActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        String[] permission = {
                Manifest.permission.READ_EXTERNAL_STORAGE
        };
        HsPermissionChecker.requestPermissions(this, permission, 10, new OnRequestPermissionResult() {
            @Override
            public void onResult(int i, @NonNull String[] strings, @NonNull int[] ints, boolean b) {
                if(b){
                    ImageProvider imageProvider = new ImageProvider(getApplicationContext(), ImageProvider.MODE_EXTERNAL);
                    ImageContents[] imageContents = imageProvider.getContents();

                    for(int j=0;j<imageContents.length;j++){
                        ImageContents idx = imageContents[j];
                        String path = idx.getDataPath();
                        ImageThumbnailProvider imageThumbnailProvider = new ImageThumbnailProvider(getContext(), ImageProvider.MODE_EXTERNAL);
                        ImageThumbnailContents imageThumbnailContents = imageThumbnailProvider.getThumbnailFromMediaId(idx.getId());
                        Log.d("a","a");
                    }

                    VideoProvider videoProvider = new VideoProvider(getApplicationContext(), VideoProvider.MODE_EXTERNAL);
                    VideoContents[] videoContents = videoProvider.getContents();

                    for(int j=0;j<videoContents.length;j++){
                        VideoContents idx = videoContents[j];
                        String path = idx.getDataPath();
                        VideoThumbnailProvider videoThumbnailProvider = new VideoThumbnailProvider(getContext(), VideoProvider.MODE_EXTERNAL);
                        VideoThumbnailContents videoThumbnailContents = videoThumbnailProvider.getThumbnailFromMediaId(idx.getId());
                        Log.d("a","a");
                    }

                    AudioProvider audioProvider = new AudioProvider(getApplicationContext(), AudioProvider.MODE_EXTERNAL);
                    AudioContents[] audioContents = audioProvider.getContents();


                    for(int j=0;j<audioContents.length;j++){
                        AudioContents idx = audioContents[j];
                        String path = idx.getDataPath();
                        AudioArtProvider audioArtProvider = new AudioArtProvider(getContext(), AudioArtProvider.MODE_EXTERNAL);
                        AudioArtContents audioArtContents = audioArtProvider.getThumbnailFromMediaId(idx.getAlbumId());
                        Log.d("a","a");
                    }

                    Log.d("a","a");
                }
            }
        });


    }
}
