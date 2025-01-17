/**
 * PW2 by Rodrigo Prestes Machado
 *
 * PW2 is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 *
*/
package dev.pw2.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

//Modelo

@Entity
@Table (name="produto")
public class Produto extends PanacheEntity {

    private static int count = 1;
    //private int id;


    @Id
    @GeneratedValue
    @Column(name="hash")
    private String hash;
    @Column(name="id")
    private Long id;
    @Column (name="nome")
    private String nome;
    @Column (name="preco")
    private Double preco;



    // @ManyToMany(mappedBy = "channels", fetch = FetchType.EAGER)
    @ManyToMany(mappedBy = "produtos", fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Utils> users;

    @ManyToMany()
    public Long getId() {
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

    public Produto() {
        this.users = new ArrayList<>();
    }

    public Produto(String nome, Double preco) {
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public Double getPreco(){
        return preco;
    }

    public void setPreco(Double preco){
        this.preco = preco;
    }

    public String toString() {
        return 
            "Hash: " + this.getHash() +
            "\nId: " + this.getId() +
            "\nNome: " + this.getNome() +
            //"\nPreco: " + Utils.doubleToString(this.getPreco());
            "\nPreco: " + this.getPreco();
    }

}
