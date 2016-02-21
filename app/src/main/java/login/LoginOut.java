package login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hack4equality.out.MainActivity;
import com.hack4equality.out.R;

/**
 * Created by RaiserAlex on 20/02/16.
 */
public class LoginOut extends Activity implements View.OnClickListener{

    Button but_login_comingOut;

    EditText edt_login_email,
             edt_login_pass;

    TextView tv_login_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_out);

        edt_login_email = (EditText) findViewById(R.id.edt_login_email);
        edt_login_pass  = (EditText) findViewById(R.id.edt_login_password);

        but_login_comingOut = (Button)findViewById(R.id.but_login);

        tv_login_register   = (TextView)findViewById(R.id.tv_login_register);

        but_login_comingOut.setOnClickListener(this);
        tv_login_register.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.but_login:

                Intent intent = new Intent(LoginOut.this, MainActivity.class);
                startActivity(intent);

                break;

            case R.id.tv_login_register:

                Toast.makeText(getApplicationContext(),"REGISTRAR",Toast.LENGTH_LONG);

                break;


        }
    }
}
