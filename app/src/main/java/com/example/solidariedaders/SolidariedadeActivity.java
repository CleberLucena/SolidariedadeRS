package com.example.solidariedaders;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class SolidariedadeActivity extends AppCompatActivity {

    private EditText etNome, etEstado, etIdade, etMensagem;
    private Button btnEnviarMensagem;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solidariedade);

        dbHelper = new DatabaseHelper(this);

        etNome = findViewById(R.id.etNome);
        etEstado = findViewById(R.id.etEstado);
        etIdade = findViewById(R.id.etIdade);
        etMensagem = findViewById(R.id.etMensagem);
        btnEnviarMensagem = findViewById(R.id.btnEnviarMensagem);

        btnEnviarMensagem.setOnClickListener(v -> {
            String nome = etNome.getText().toString();
            String estado = etEstado.getText().toString();
            String idade = etIdade.getText().toString();
            String mensagem = etMensagem.getText().toString();

            if (nome.isEmpty() || estado.isEmpty() || idade.isEmpty() || mensagem.isEmpty()) {
                Toast.makeText(SolidariedadeActivity.this, "Por favor, preencha todos os campos!", Toast.LENGTH_SHORT).show();
            } else {
                insertUserData(nome, estado, Integer.parseInt(idade), mensagem);
                Toast.makeText(SolidariedadeActivity.this, "Mensagem enviada com sucesso!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void insertUserData(String name, String state, int age, String message) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("state", state);
        values.put("age", age);
        values.put("message", message);

        Log.d("Database", "Inserindo dados: Nome=" + name + ", Estado=" + state + ", Idade=" + age + ", Mensagem=" + message);

        long newRowId = db.insert("users", null, values);
        if (newRowId == -1) {
            Log.e("Database", "Erro ao inserir dados");
        } else {
            Log.d("Database", "Dados inseridos com sucesso, ID: " + newRowId);
        }
    }

}
