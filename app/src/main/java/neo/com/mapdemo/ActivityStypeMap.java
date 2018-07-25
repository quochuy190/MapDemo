package neo.com.mapdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Quốc Huy
 * @version 1.0.0
 * @description
 * @desc Developer NEO Company.
 * @created 7/23/2018
 * @updated 7/23/2018
 * @modified by
 * @updated on 7/23/2018
 * @since 1.0
 */
public class ActivityStypeMap extends AppCompatActivity implements OnMapReadyCallback {
    GoogleMap mMap;
    Spinner spinner;
    ArrayList<String> arrStype;
    ArrayAdapter<String> adapterStype;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stype_map);
        init();
        initEvent();
    }

    private void initEvent() {
    }

    private void init() {
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        spinner = findViewById(R.id.spinner_stype);
        arrStype = new ArrayList<>();
        arrStype.addAll(Arrays.asList(getResources().getStringArray(R.array.arrStype)));
        adapterStype = new ArrayAdapter<String>(ActivityStypeMap.this,
                android.R.layout.simple_spinner_item,
                arrStype);
        adapterStype.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapterStype);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                xuLyDoiMapType(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng sydney = new LatLng(21.050790, 105.783510);
        mMap.addMarker(new MarkerOptions()
                .position(sydney)
                .title("IMIC")
                .snippet("iMic - Nơi đào tạo lập trình viên hàng đầu Việt Nam. ")
        );
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 13));
    }

    private void xuLyDoiMapType(int position) {
        switch (position) {
            case 0:
                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                break;
            case 1:
                mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                break;
            case 2:
                mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                break;
            case 3:
                mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                break;
        }
    }

}
