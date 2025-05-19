package com.example.hotel.ui.room;

import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hotel.R;
import com.example.hotel.contacter;
import com.example.hotel.rooM1;
import com.example.hotel.rooM2;
public class room extends Fragment {
    private View Room1, Room2, Room3, Room4, Room5, Room6, Room7, Room8, Room9, Room10;
    private RoomViewModel mViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_room, container, false);

        Room1 = v.findViewById(R.id.rooMM1);
        Room2 = v.findViewById(R.id.rooMM2);
        Room3 = v.findViewById(R.id.im3);
        Room4 = v.findViewById(R.id.im4);
        Room5 = v.findViewById(R.id.im5);
        Room6 = v.findViewById(R.id.im6);
        Room7 = v.findViewById(R.id.im7);
        Room8 = v.findViewById(R.id.im8);
        Room9 = v.findViewById(R.id.im9);
        Room10 = v.findViewById(R.id.im10);

        setRoomClick(Room1, rooM1.class);
        setRoomClick(Room2, rooM2.class);
        setRoomClick(Room3, rooM1.class);
        setRoomClick(Room4, rooM2.class);
        setRoomClick(Room5, rooM1.class);
        setRoomClick(Room6, rooM2.class);
        setRoomClick(Room7, rooM1.class);
        setRoomClick(Room8, rooM2.class);
        setRoomClick(Room9, rooM1.class);
        setRoomClick(Room10, rooM2.class);

        return v;
    }

    private void setRoomClick(View view, Class<?> destination) {
        view.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), destination);
            startActivity(intent);
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(RoomViewModel.class);
    }
}
