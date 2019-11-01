package org.openstack4j.model.network;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.openstack4j.common.Buildable;
import org.openstack4j.model.common.Resource;
import org.openstack4j.model.network.builder.Layer2GatewayBuilder;
import org.openstack4j.openstack.networking.domain.NeutronLayer2Gateway;

import java.util.List;

public interface Layer2Gateway extends Resource, Buildable<Layer2GatewayBuilder> {
    List<? extends Device> getDevices();

    @JsonDeserialize(as = NeutronLayer2Gateway.DeviceImpl.class)
    interface Device {
        List<? extends Interface> getInterfaces();

        String getDeviceName();

        @JsonDeserialize(as = NeutronLayer2Gateway.InterfaceImpl.class)
        interface Interface {
            String getName();

            List<String> getSegmentationId();
        }
    }
}

