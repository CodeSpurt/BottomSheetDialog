package com.codespurt.bottomsheetdialog;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button dialog;
    private TextView camera, gallery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dialog = (Button) findViewById(R.id.btn_open_dialog);
    }

    @Override
    protected void onResume() {
        super.onResume();
        dialog.setOnClickListener(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        dialog.setOnClickListener(null);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_open_dialog:
                openBottomSheet();
                break;
            case R.id.tv_camera:
                Toast.makeText(this, getResources().getString(R.string.camera), Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_gallery:
                Toast.makeText(this, getResources().getString(R.string.gallery), Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void openBottomSheet() {
        View view = getLayoutInflater().inflate(R.layout.bottom_sheet, null);
        camera = (TextView) view.findViewById(R.id.tv_camera);
        gallery = (TextView) view.findViewById(R.id.tv_gallery);

        final Dialog mBottomSheetDialog = new Dialog(this, R.style.MaterialDialogSheet);
        mBottomSheetDialog.setContentView(view);
        mBottomSheetDialog.setCancelable(true);
        mBottomSheetDialog.getWindow().setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        mBottomSheetDialog.getWindow().setGravity(Gravity.BOTTOM);
        mBottomSheetDialog.show();

        camera.setOnClickListener(this);
        gallery.setOnClickListener(this);
    }
}
