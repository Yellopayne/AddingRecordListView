package yello.putinto2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MessageReceiver extends AppCompatActivity {

    private static TextView tv3;
    private static String [] nazwy =new String [10];
    private static ArrayList<String> arrayL = new ArrayList<String>();
    private static ListView lv;
    private static Button btn2,goBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_receiver);

        displayList();
        removeRecord();
        goBack();
        displayMessage();



    }

    public  void displayList(){
        String fristActivityValue=getIntent().getExtras().getString("value");
        arrayL.add(fristActivityValue);
        ArrayAdapter<String> ap = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                arrayL);
        lv=(ListView)findViewById(R.id.listaDanych);
        lv.setAdapter(ap);
    }
    public void removeRecord(){
        btn2=(Button)findViewById(R.id.button2);


            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!arrayL.isEmpty()) {
                        arrayL.remove(0);
                        ArrayAdapter<String> ap = new ArrayAdapter<String>(getApplicationContext(),
                                android.R.layout.simple_list_item_1,
                                arrayL);
                        lv = (ListView) findViewById(R.id.listaDanych);
                        lv.setAdapter(ap);

                    } else {
                        Toast.makeText(getApplicationContext(), "DataBase is Empty :C", Toast.LENGTH_SHORT).show();
                    }


                }
            });
        }

    public void goBack(){
        goBack=(Button)findViewById(R.id.goBackButton);
        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(MessageReceiver.this,Menu.class);
                startActivity(intent3);
            }
        });

    }


    public void displayMessage(){
        lv =(ListView)findViewById(R.id.listaDanych);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String messageFromArray = arrayL.get(position);
                Toast.makeText(getApplicationContext(),messageFromArray,Toast.LENGTH_SHORT).show();
            }
        });
    }


}
