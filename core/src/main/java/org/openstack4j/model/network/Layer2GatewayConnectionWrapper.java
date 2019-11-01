package org.openstack4j.model.network;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.openstack4j.model.ModelEntity;
import org.openstack4j.openstack.networking.domain.NeutronLayer2GatewayConnection;

public class Layer2GatewayConnectionWrapper implements ModelEntity {
    @JsonProperty("l2_gateway_connection")
    @JsonDeserialize(as = NeutronLayer2GatewayConnection.class)
    private Layer2GatewayConnection connection;

    public Layer2GatewayConnectionWrapper() {}

    public Layer2GatewayConnectionWrapper(Layer2GatewayConnection connection) {
        this.connection = connection;
    }

    public Layer2GatewayConnection getConnection() {
        return connection;
    }

    public void setConnection(Layer2GatewayConnection connection) {
        this.connection = connection;
    }
}
