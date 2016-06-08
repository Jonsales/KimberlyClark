package br.com.john.kimberlyclark;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.john.kimberlyclark.Services.AllActivitys;

public class LoginActivity extends AppCompatActivity {
    EditText editLogin, editPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        editLogin = (EditText) findViewById(R.id.edit_login);
        editPassword = (EditText) findViewById(R.id.edit_password);
        btnLogin = (Button) findViewById(R.id.btn_entrar);

        btnLogin.setOnLongClickListener(onLongClickListener);
        btnLogin.setOnClickListener(onClickLoginListener);

        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public View.OnLongClickListener onLongClickListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            editLogin.setText("admin@admin.com.br");
            editPassword.setText("admin123");
            return true;
        }
    };

    public View.OnClickListener onClickLoginListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(validateEmail(editLogin)){
                if(validatePassword(editPassword)) {
                    Intent i = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(i);
                    LoginActivity.this.finish();
                }
            }
        }
    };

    public boolean validateEmail(EditText email){
        if (getString(email).matches("[a-zA-Z0-9._-]+@[a-z]+.[a-z]+") ||
                getString(email).matches("[a-zA-Z0-9._-]+@[a-z]+.[a-z]+.[a-z]+") &&
                        getString(email).length() > 0) {

            return true;
        }
        else{
            changeColorEdit(email, "Por favor, insira um e-mail válido.");
            return false;
        }

    }

    public boolean validatePassword(EditText edit){
        if(getString(edit).length()>=5){
            return true;
        }
        else {
            changeColorEdit(edit, "Por favor, insira uma senha válida.");
            return false;
        }
    }

    public void changeColorEdit(EditText edit, String mensagem){
        edit.setBackground(getResources().getDrawable(R.drawable.background_edit_error));
        createAlert("Dados Inválidos", mensagem);
    }

    private String getString(EditText edit){
        return edit.getText().toString().trim().equals("") ? " " : edit.getText().toString();
    }

    public boolean isOnline() {
        ConnectivityManager cm =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        }else{
            Toast.makeText(this,"É necessário uma conexão com a internet.", Toast.LENGTH_LONG).show();
        }
        return false;
    }

    private void createAlert(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setPositiveButton("Ok", null);
        builder.setMessage(message);
        builder.setTitle(title);
        builder.create().show();
    }
}
