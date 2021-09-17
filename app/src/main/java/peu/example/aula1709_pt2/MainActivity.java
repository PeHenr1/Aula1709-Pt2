package peu.example.aula1709_pt2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // atributos referentes aos objetos gráficos
    private EditText txtNome;
    private EditText txtEmail;
    private EditText txtTelefone;
    private Button btnAdiciona;
    private ListView listaContatos;

    // ArrayList de contatos
    private ArrayList<Contato> contatos = new ArrayList<>();

    // adapter da lista
    private AdapterContatos adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ligando atributos com os ID dos objetos na interface
        txtNome = findViewById( R.id.txtNome );
        txtEmail = findViewById( R.id.txtEmail );
        txtTelefone = findViewById( R.id.txtTelefone );
        btnAdiciona = findViewById( R.id.btnAdiciona );
        listaContatos = findViewById( R.id.listaContatos );

        // criando e associando escutador do botão
        btnAdiciona.setOnClickListener( new EscutadorBotao() );

        // configurando a lista:

        // criando adaptador
        adaptador = new AdapterContatos( this, contatos );

        // associando o adaptador a lista
        listaContatos.setAdapter( adaptador );
    }
    // classe interna do escutador do clique no botão adiciona
    private class EscutadorBotao implements View.OnClickListener {

        @Override
        public void onClick(View view) {

            // variaveis para auxilio
            String nome;
            String email;
            String telefone;

            // pegando dados nas caixas de texto
            nome = txtNome.getText().toString();
            email = txtEmail.getText().toString();
            telefone = txtTelefone.getText().toString();

            // criando objeto Contato
            Contato c = new Contato( nome, email, telefone );

            // inserindo no ArrayList
            contatos.add( c );

            // avisando o adapter que os dados foram atualizados
            adaptador.notifyDataSetChanged();

            // "limpando" a interface, para a próxima digitação
            txtNome.setText("");
            txtEmail.setText("");
            txtTelefone.setText("");
        }
    }
}