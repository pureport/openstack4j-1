package org.openstack4j.model.network;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.openstack4j.model.ModelEntity;
import org.openstack4j.openstack.networking.domain.NeutronLayer2Gateway;

public class Layer2GatewayWrapper implements ModelEntity {
    @JsonProperty("l2_gateway")
    @JsonDeserialize(as = NeutronLayer2Gateway.class)
    private Layer2Gateway gateway;

    public Layer2GatewayWrapper() {}

    public Layer2GatewayWrapper(Layer2Gateway gateway) {
        this.gateway = gateway;
    }

    public Layer2Gateway getGateway() {
        return gateway;
    }

    public void setGateway(Layer2Gateway gateway) {
        this.gateway = gateway;
    }
}
