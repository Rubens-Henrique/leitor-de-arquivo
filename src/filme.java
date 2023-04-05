import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class filme {
  protected     int idFilme;
  protected  String titulo;
  protected  float imdb;
  protected String genero;
  
    public filme(int i, String t, float n,String g) {
          this.idFilme = i;
          this.titulo = t;
          this.imdb = n;
      this.genero = g;
        }

    public filme() {
      //atribuindo
          idFilme = -1;
          titulo = "";
          imdb = 0.F;
          genero="";
        }

        public String toString() {
          return "\nID: " + idFilme + 
                 "\nTítulo: " + titulo + 
                 "\nimdb:  " + imdb + 
                "\ngenero:  " +genero ;  
        }

        public byte[] toByteArray() throws IOException {
          ByteArrayOutputStream baos = new ByteArrayOutputStream();
          DataOutputStream dos = new DataOutputStream(baos);
          dos.writeInt(idFilme);
          dos.writeUTF(titulo);
          dos.writeFloat(imdb);
          dos.writeUTF(genero);
          return baos.toByteArray();
        }
      
        public void fromByteArray(byte[] ba) throws IOException {
          ByteArrayInputStream bais = new ByteArrayInputStream(ba);
          DataInputStream dis = new DataInputStream(bais);
          idFilme = dis.readInt();
          titulo = dis.readUTF();
          imdb = dis.readFloat();
          genero = dis.readUTF();
        }
}


