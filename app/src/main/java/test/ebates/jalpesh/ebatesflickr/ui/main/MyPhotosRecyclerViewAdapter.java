package test.ebates.jalpesh.ebatesflickr.ui.main;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

import test.ebates.jalpesh.ebatesflickr.R;
import test.ebates.jalpesh.ebatesflickr.backendLayer.models.Photo;
import test.ebates.jalpesh.ebatesflickr.ui.main.PhotosFragment.OnListFragmentInteractionListener;
import test.ebates.jalpesh.ebatesflickr.utils.AppConstants;

public class MyPhotosRecyclerViewAdapter extends RecyclerView.Adapter<MyPhotosRecyclerViewAdapter.ViewHolder> {

    private final List<Photo> mValues;
    private final OnListFragmentInteractionListener mListener;
    private final Activity activityContext;

    public MyPhotosRecyclerViewAdapter(List<Photo> items, OnListFragmentInteractionListener listener, Activity activity) {
        mValues = items;
        mListener = listener;
        activityContext = activity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_photos, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        Picasso.with(activityContext)
                .load(holder.mItem.getPhotoUrl(AppConstants.IMAGE_SIZE_CONSTANTS.MEDIUM_IMAGE_SIZE))
                .into(holder.mIdView, new Callback() {
                    @Override
                    public void onSuccess() {
                        holder.mIdView.setVisibility(View.VISIBLE);
                        holder.loader.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError() {
                        holder.loader.setVisibility(View.GONE);
                    }
                });

        holder.mContentView.setText(mValues.get(position).getTitle());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final View mView;
        final ImageView mIdView;
        final TextView mContentView;
        final ProgressBar loader;
        Photo mItem;

        ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = (ImageView) view.findViewById(R.id.item_number);
            mContentView = (TextView) view.findViewById(R.id.content);
            loader = (ProgressBar) view.findViewById(R.id.small_thumb_progress_bar);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
