package org.openstack4j.model.network;

import org.openstack4j.common.Buildable;
import org.openstack4j.model.common.Resource;
import org.openstack4j.model.network.builder.Layer2GatewayConnectionBuilder;

public interface Layer2GatewayConnection extends Resource, Buildable<Layer2GatewayConnectionBuilder> {
    String getGatewayId();

    void setGatewayId(String gatewayId);

    String getNetworkId();

    void setNetworkId(String networkId);

    String getSegmentationId();

    void setSegmentationId(String segmentationId);
}

