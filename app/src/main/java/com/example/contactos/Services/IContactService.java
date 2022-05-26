package com.example.contactos.Services;

import android.telecom.Call;

import com.example.contactos.Entities.Contacto;

import java.util.List;

import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;


public interface IContactService {
    @GET("contacts")
    retrofit2.Call<List<Contacto>> getContacts();

    // contacts/:id
    @GET("contacts/{id}")
    retrofit2.Call<Contacto> findContact(@Path("id") int id);

    @POST("contacts")
    retrofit2.Call<Contacto> create(@Body Contacto contact);

    @DELETE("contacts/{id}")
    retrofit2.Call<Contacto> delete(@Path("Id") int Id);
}
