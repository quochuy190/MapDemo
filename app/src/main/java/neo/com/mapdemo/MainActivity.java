package neo.com.mapdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * @author Quốc Huy
 * @version 1.0.0
 * @description
 * @desc Developer NEO Company.
 * @created 7/25/2018
 * @updated 7/25/2018
 * @modified by
 * @updated on 7/25/2018
 * @since 1.0
 */
public class MainActivity extends AppCompatActivity {
    Button btn_stype_map, btn_location, btn_add_polyline, btn_chi_duong;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        init();
        initEvent();
    }

    private void initEvent() {
        btn_stype_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ActivityStypeMap.class));
            }
        });
        btn_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ActivityGetLocation.class));
            }
        });
        btn_add_polyline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MapsActivity.class));
            }
        });
        btn_add_polyline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ActivityDerection.class));
            }
        });
    }

    private void init() {
        btn_stype_map = findViewById(R.id.btn_type_map);
        btn_location = findViewById(R.id.btn_get_location);
        btn_add_polyline = findViewById(R.id.btn_ve_duong);
        btn_chi_duong = findViewById(R.id.btn_chi_duong);
    }
}
