package br.edu.ifsp.hto.votacao.entities;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Arrays;
import java.util.List;

public class Candidato implements Parcelable{
    private String nome;
    private int numero;
    private TiposCandidatosEnum tiposCandidatosEnum;

    public Candidato(String nome, int numero, TiposCandidatosEnum tiposCandidatosEnum) {
        this.nome = nome;
        this.numero = numero;
        this.tiposCandidatosEnum = tiposCandidatosEnum;
    }

    protected Candidato(Parcel in) {
        nome = in.readString();
        numero = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nome);
        dest.writeInt(numero);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Candidato> CREATOR = new Creator<Candidato>() {
        @Override
        public Candidato createFromParcel(Parcel in) {
            return new Candidato(in);
        }

        @Override
        public Candidato[] newArray(int size) {
            return new Candidato[size];
        }
    };

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public TiposCandidatosEnum getTiposCandidatosEnum() {
        return tiposCandidatosEnum;
    }

    public void setTiposCandidatosEnum(TiposCandidatosEnum tiposCandidatosEnum) {
        this.tiposCandidatosEnum = tiposCandidatosEnum;
    }

    public static List<Candidato> getPresidentes(){
        return Arrays.asList(
                new Candidato("João", 10, TiposCandidatosEnum.PRESIDENTE),
                new Candidato("Maria", 20, TiposCandidatosEnum.PRESIDENTE),
                new Candidato("José", 30, TiposCandidatosEnum.PRESIDENTE),
                new Candidato("Pedro", 40, TiposCandidatosEnum.PRESIDENTE),
                new Candidato("Lúcia", 50, TiposCandidatosEnum.PRESIDENTE),
                new Candidato("Roberta", 60, TiposCandidatosEnum.PRESIDENTE)
        );
    }

    public static List<Candidato> getSenador(){
        return Arrays.asList(
                new Candidato("Melina", 100, TiposCandidatosEnum.SENADOR),
                new Candidato("Jéssica", 200, TiposCandidatosEnum.SENADOR),
                new Candidato("Mário", 300, TiposCandidatosEnum.SENADOR),
                new Candidato("Ronaldo", 400, TiposCandidatosEnum.SENADOR),
                new Candidato("Daniela", 500, TiposCandidatosEnum.SENADOR),
                new Candidato("Zuleide", 600, TiposCandidatosEnum.SENADOR)
        );
    }
}

