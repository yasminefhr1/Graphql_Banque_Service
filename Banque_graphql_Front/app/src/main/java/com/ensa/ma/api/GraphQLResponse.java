package com.ensa.ma.api;

import com.ensa.ma.model.Compte;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class GraphQLResponse {
    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public static class Data {
        @SerializedName("allComptes")
        private List<Compte> allComptes;

        public List<Compte> getAllComptes() {
            return allComptes;
        }

        public void setAllComptes(List<Compte> allComptes) {
            this.allComptes = allComptes;
        }
    }
}
