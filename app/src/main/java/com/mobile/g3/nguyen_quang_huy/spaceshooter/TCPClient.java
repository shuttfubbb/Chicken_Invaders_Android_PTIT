package com.mobile.g3.nguyen_quang_huy.spaceshooter;

import android.util.Log;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

import model.History;
import model.Level;
import model.Member;

public class TCPClient {
    public String host;
    public TCPClient(){
        this.host = "192.168.0.100";
    }

    public boolean checkLogin(Member member) {
        try{
            Log.d("member", "0");
            Socket socket = new Socket("192.168.0.100", 2001);

            Log.d("member", "1");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            String mess = "checkLogin";
            Log.d("member", "2");
            dataOutputStream.writeUTF(mess);

            objectOutputStream.writeObject(member);
            member = (Member)objectInputStream.readObject();
            Log.d("member", member.getName());
        }catch (IOException | ClassNotFoundException e){
            Log.d("member", "3");
            e.printStackTrace();
            return false;
        }
        Log.d("member", member.getName());
        if(member.getName() == ""){
            return false;
        }
        return true;
    }

    public ArrayList<Level> getAllLevel() throws ClassNotFoundException {
        ArrayList<Level> levels = new ArrayList<Level>();
        try{
            Socket socket = new Socket("192.168.0.102", 8888);

            OutputStream ouputstream = socket.getOutputStream();
            InputStream inputStream = socket.getInputStream();

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(ouputstream);
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            DataOutputStream dataOutputStream = new DataOutputStream(ouputstream);
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            String mess = "getAllLevels";
            dataOutputStream.writeUTF(mess);

            levels = (ArrayList<Level>)objectInputStream.readObject();
        }catch (IOException e){
            e.printStackTrace();
        }
        return levels;
    }

    public boolean add(History history) throws ClassNotFoundException {
        boolean result = false;
        try{
            Socket socket = new Socket("192.168.0.102", 8888);

            OutputStream ouputstream = socket.getOutputStream();
            InputStream inputStream = socket.getInputStream();

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(ouputstream);
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            DataOutputStream dataOutputStream = new DataOutputStream(ouputstream);
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            String mess = "addHistory";
            dataOutputStream.writeUTF(mess);
            objectOutputStream.writeObject(history);

            result = dataInputStream.readBoolean();
        }catch (IOException e){
            e.printStackTrace();
            return false;
        }
        return result;
    }

}
