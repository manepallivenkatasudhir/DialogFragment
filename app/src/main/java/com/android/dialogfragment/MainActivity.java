package com.android.dialogfragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.android.dialogfragment.dialogFragments.SampleDialogFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button showAlertDialogFragment =(Button)findViewById(R.id.showAlertDialogFragment);
        showAlertDialogFragment.setOnClickListener(this);
    }

    public void onClick(View view) {
        // close existing dialog fragments
        FragmentManager manager = getFragmentManager();
        Fragment frag = manager.findFragmentByTag("fragment_edit_name");
        if (frag != null) {
            manager.beginTransaction().remove(frag).commit();
        }
        switch (view.getId()) {
            case R.id.showAlertDialogFragment:
                SampleDialogFragment sampleDialogFragment = new SampleDialogFragment();
                sampleDialogFragment.show(manager, "fragment_edit_name");
                break;
        }
    }
}
