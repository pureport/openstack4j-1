package org.openstack4j.model.network.builder;

import org.openstack4j.common.Buildable.Builder;
import org.openstack4j.model.network.Layer2GatewayConnection;

public interface Layer2GatewayConnectionBuilder extends Builder<Layer2GatewayConnectionBuilder, Layer2GatewayConnection> {
    Layer2GatewayConnectionBuilder tenantId(String tenantId);

    Layer2GatewayConnectionBuilder id(String id);

    Layer2GatewayConnectionBuilder name(String name);

    Layer2GatewayConnectionBuilder gatewayId(String gatewayId);

    Layer2GatewayConnectionBuilder networkId(String networkId);

    Layer2GatewayConnectionBuilder segmentationId(String segmentationId);
}
