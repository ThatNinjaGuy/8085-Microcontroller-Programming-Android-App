package vishalgautam.a8085emulator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Interface extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interface);
    }

    public void GoToTutorials(View view){
        Intent intent = new Intent(Interface.this,Tutorials.class);
        startActivity(intent);
    }

    public void GoToEmulator(View view){
        Intent intent = new Intent(Interface.this,Emulator.class);
        startActivity(intent);
    }

    public void GoToSampleCodes(View view){
        Intent intent = new Intent(Interface.this,SampleCodes.class);
        startActivity(intent);
    }

    public void GoToInstructions(View view){
        Intent intent = new Intent(Interface.this,Instructions.class);
        startActivity(intent);
    }
}
