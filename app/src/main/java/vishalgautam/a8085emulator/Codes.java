package vishalgautam.a8085emulator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Codes extends AppCompatActivity {

    static TextView code_title,specific_code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_codes);

        code_title = (TextView)findViewById(R.id.code_title);
        specific_code = (TextView)findViewById(R.id.specific_code);

        Bundle bundle = getIntent().getExtras();
        code_title.setText(bundle.getString("TITLE"));
        int position = bundle.getInt("POSITION");
        specific_code.setText(getResources().getStringArray(R.array.sample_codes_code)[position]);

    }
}
