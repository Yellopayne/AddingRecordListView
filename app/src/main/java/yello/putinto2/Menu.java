package yello.putinto2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Menu extends AppCompatActivity {

    private EditText ed;
    private Button btn;
    private Button goTo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        sendMessage();


    }



    public void sendMessage(){
        ed =(EditText)findViewById(R.id.editText);
        btn = (Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Record has been added", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(Menu.this, MessageReceiver.class);
                intent1.putExtra("value", ed.getText().toString());
                startActivity(intent1);


            }
        });


    }


}
