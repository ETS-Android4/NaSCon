package com.muhammadanasashir.nascon;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.onesignal.OneSignal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import java.util.List;

import static java.net.Proxy.Type.HTTP;

public class ContactUs extends AppCompatActivity {
    DrawerLayout drawr;
    ImageButton menu;
    Button home;
    Button events;
    Button register;
    Button notifications;
    Button memories;
    Button adminLogin;
    Button contact ;
    Button developers;
    Button call1;
    Button call2;
    Button call3;
    Button email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactus);

        drawr=findViewById(R.id.drwr);
        menu=findViewById(R.id.menu);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(drawr.isDrawerOpen(Gravity.LEFT))
                {
                    drawr.closeDrawer(Gravity.LEFT);
                }
                else
                {
                    drawr.openDrawer(Gravity.LEFT);
                }
            }
        });

        home = findViewById(R.id.id_btn_home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ContactUs.this, MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                drawr.closeDrawer(Gravity.LEFT);
                //finish();
            }
        });

        events = findViewById(R.id.id_btn_events);
        events.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ContactUs.this, Events.class));
                finish();
            }
        });

        register = findViewById(R.id.id_btn_register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ContactUs.this, RegisterStepOne.class));
                finish();
            }
        });

        notifications = findViewById(R.id.id_btn_notifications);
        notifications.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ContactUs.this, Notifications.class));
                finish();
            }
        });

        memories = findViewById(R.id.id_btn_memories);
        memories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ContactUs.this, Memories.class));
                finish();
            }
        });

        adminLogin = findViewById(R.id.id_btn_adminlogin);
        adminLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ContactUs.this, AdminLogin.class));
                finish();
            }
        });

        developers = findViewById(R.id.id_btn_developers);
        developers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ContactUs.this, Developers.class));
                drawr.closeDrawer(Gravity.LEFT);
            }
        });

        contact = findViewById(R.id.id_btn_contactus);
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawr.closeDrawer(Gravity.LEFT);
            }
        });

        call1 = findViewById(R.id.id_btn_call_1);
        call1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri number = Uri.parse("tel:+923246498591");
                Intent callIntent = new Intent(Intent.ACTION_DIAL, number);

                PackageManager packageManager = getPackageManager();
                List<ResolveInfo> activities = packageManager.queryIntentActivities(callIntent, 0);
                boolean isIntentSafe = activities.size() > 0;

                if (isIntentSafe) {
                    startActivity(callIntent);
                }
            }
        });

        call2 = findViewById(R.id.id_btn_call_2);
        call2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri number = Uri.parse("tel:+923358151558");
                Intent callIntent = new Intent(Intent.ACTION_DIAL, number);

                PackageManager packageManager = getPackageManager();
                List<ResolveInfo> activities = packageManager.queryIntentActivities(callIntent, 0);
                boolean isIntentSafe = activities.size() > 0;

                if (isIntentSafe) {
                    startActivity(callIntent);
                }
            }
        });

        call3 = findViewById(R.id.id_btn_call_3);
        call3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri number = Uri.parse("tel:+923162008000");
                Intent callIntent = new Intent(Intent.ACTION_DIAL, number);

                PackageManager packageManager = getPackageManager();
                List<ResolveInfo> activities = packageManager.queryIntentActivities(callIntent, 0);
                boolean isIntentSafe = activities.size() > 0;

                if (isIntentSafe) {
                    startActivity(callIntent);
                }
            }
        });

        email = findViewById(R.id.id_btn_email);
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intent = new Intent(Intent.ACTION_VIEW)
                        //.setType("text/plain")
                        .setType("message/rfc822")
                        .setData(Uri.parse("wearegroot.smd@gmail.com"))
                        //.setClassName("com.google.android.gm", "com.google.android.gm.ComposeActivityGmail")
                        //.putExtra(Intent.EXTRA_EMAIL, new String[]{"test@gmail.com"})
                        .putExtra(Intent.EXTRA_SUBJECT, "Query regarding NaSCon")
                        .putExtra(Intent.EXTRA_TEXT, "As Salam o Alaikum! ");
                //startActivity(intent);
                startActivity(Intent.createChooser(intent, "Choose an email client"));
            }
        });
    }
}