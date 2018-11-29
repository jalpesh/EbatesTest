package test.ebates.jalpesh.ebatesflickr.ui.main;


import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

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
        if(savedInstanceState!=null && savedInstanceState.containsKey(AppConstants.COMMON_CONSTANTS.PHOTO_PARCEL)){
            theBombPhoto = savedInstanceState.getParcelable(AppConstants.COMMON_CONSTANTS.PHOTO_PARCEL);
        }

        if(theBombPhoto!=null){
            Picasso.with(getActivity()).load(theBombPhoto.getPhotoUrl(AppConstants.IMAGE_SIZE_CONSTANTS.ORIGINAL_IMAGE_SIZE)).into(photoView);
        }


    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }
}
