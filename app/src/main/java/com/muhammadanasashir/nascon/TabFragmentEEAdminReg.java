package com.muhammadanasashir.nascon;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class TabFragmentEEAdminReg extends Fragment {

    RecyclerView ee ;
    AdminEventRegistrationAdapter eventAdapter;
    ArrayList<EventNode> eventsList ;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_tab_ee_admin_reg, container, false);


        ee = rootView.findViewById(R.id.id_rv_EE);

        ee.setHasFixedSize(true);
        ee.setLayoutManager(new LinearLayoutManager(getContext()));

        eventsList = new ArrayList<>();
        readEvents();

        return rootView;
    }

    private void readEvents() {

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Events");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                eventsList.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren())
                {
                    EventNode event = snapshot.getValue(EventNode.class);

                    assert event != null ;

                    if (event.getCategory().equals("EE"))
                    {
                        eventsList.add(event);
                    }


                }

                eventAdapter = new AdminEventRegistrationAdapter(getContext() , eventsList);
                ee.setAdapter(eventAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}