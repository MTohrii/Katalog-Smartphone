package com.example.smartphonetopik7.model;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.UUID;

public class Lis {
    public static final String APPLE = "APPLE";
    public static final String SAMSUNG = "SAMSUNG";
    public static final String VIVO = "VIVO";
    public static final String OPPO = "OPPO";
    public static final String XIOMI = "XIOMI";


    private String id;
    private String spesifikasi;
    private String harga;
    private String brand;
    private String model;

    public Lis() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSpesifikasi() {
        return spesifikasi;
    }

    public void setSpesifikasi(String spesifikasi) {
        this.spesifikasi = spesifikasi;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public static Lis fromJSONObject(JSONObject obj) {
        Lis tr = new Lis();
        try {
            tr.setId(obj.getString("id"));
            tr.setSpesifikasi(obj.getString("spesifikasi"));
            tr.setHarga(obj.getString("harga"));
            tr.setBrand(obj.getString("brand"));
            tr.setModel(obj.getString("model"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return tr;
    }

    public JSONObject toJSONObject() {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("id", this.id);
            jsonObj.put("spesifikasi", this.spesifikasi);
            jsonObj.put("harga", this.harga);
            jsonObj.put("brand", this.brand);
            jsonObj.put("model", this.model);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObj;
    }


}
