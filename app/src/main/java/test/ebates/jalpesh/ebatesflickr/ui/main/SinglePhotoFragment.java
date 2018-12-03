package test.ebates.jalpesh.ebatesflickr.ui.main;


import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import test.ebates.jalpesh.ebatesflickr.R;
import test.ebates.jalpesh.ebatesflickr.models.Photo;
import test.ebates.jalpesh.ebatesflickr.utils.AppConstants;

/**
 * A simple {@link Fragment} subclass.
 */
public class SinglePhotoFragment extends Fragment {

    ImageView fullScreenImage;
    Photo theBombPhoto;
    ImageView photoView;
    ProgressBar loader;

    public SinglePhotoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        theBombPhoto = getArguments().getParcelable(AppConstants.COMMON_CONSTANTS.PHOTO_PARCEL);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_single_photo, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        photoView = getActivity().findViewById(R.id.fullScreenImage);
        loader = getActivity().findViewById(R.id.large_thumb_progress_bar);
        if(savedInstanceState!=null && savedInstanceState.containsKey(AppConstants.COMMON_CONSTANTS.PHOTO_PARCEL)){
            theBombPhoto = savedInstanceState.getParcelable(AppConstants.COMMON_CONSTANTS.PHOTO_PARCEL);
        }

        if(theBombPhoto!=null){

            //Get default photo URL
            String urlToLoad = theBombPhoto.getPhotoUrl(AppConstants.IMAGE_SIZE_CONSTANTS.ORIGINAL_IMAGE_SIZE);

            //Load large image if returned in extras.
            if(theBombPhoto.getUrl_l()!=null && !theBombPhoto.getUrl_l().isEmpty()){
                urlToLoad = theBombPhoto.getUrl_l();
            }

            //ORIGINAL_IMAGE_SIZE

            Picasso.with(getActivity())
                    .load(urlToLoad)
                    .into(photoView, new Callback() {
                @Override
                public void onSuccess() {
                    loader.setVisibility(View.GONE);
                    Log.d("loadImg","image loaded");
                }

                @Override
                public void onError() {
                    Log.d("loadImg","image loading error");
                }
            });
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }
}
