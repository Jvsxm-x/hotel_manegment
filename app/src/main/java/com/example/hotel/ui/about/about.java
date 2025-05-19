package com.example.hotel.ui.about;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.hotel.R;
import com.example.hotel.rooM1;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.ListResult;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;

public class about extends Fragment {

    private RecyclerView mRecyclerView;
    private MyAdapter mAdapter;
    private final List<String> mImageUrls = new ArrayList<>();

    private StorageReference mStorageRef;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about, container, false);

        mRecyclerView = view.findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        mAdapter = new MyAdapter(mImageUrls, getContext());
        mRecyclerView.setAdapter(mAdapter);

        mStorageRef = FirebaseStorage.getInstance().getReference().child("upload");

        // Fetch images from Firebase Storage
        mStorageRef.listAll().addOnSuccessListener(listResult -> {
            for (StorageReference item : listResult.getItems()) {
                item.getDownloadUrl().addOnSuccessListener(uri -> {
                    mImageUrls.add(uri.toString());
                    mAdapter.notifyItemInserted(mImageUrls.size() - 1);
                });
            }
        });

        return view;
    }

    private static class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

        private final List<String> mImageUrls;
        private final Context context;

        public MyAdapter(List<String> imageUrls, Context context) {
            this.mImageUrls = imageUrls;
            this.context = context;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            String imageUrl = mImageUrls.get(position);

            Glide.with(context)
                    .load(imageUrl)
                    .centerCrop()
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(holder.mImageView);

            holder.mImageView.setOnClickListener(v -> {
                Intent intent = new Intent(context, rooM1.class);
                context.startActivity(intent);
            });
        }

        @Override
        public int getItemCount() {
            return mImageUrls.size();
        }

        public static class ViewHolder extends RecyclerView.ViewHolder {
            public final ImageView mImageView;

            public ViewHolder(View itemView) {
                super(itemView);
                mImageView = itemView.findViewById(R.id.imageView);
            }
        }
    }
}
