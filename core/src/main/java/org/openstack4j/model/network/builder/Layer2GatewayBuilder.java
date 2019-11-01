package org.openstack4j.model.network.builder;

import org.openstack4j.common.Buildable.Builder;
import org.openstack4j.model.network.Layer2Gateway;

import java.util.List;

public interface Layer2GatewayBuilder extends Builder<Layer2GatewayBuilder, Layer2Gateway> {
    Layer2GatewayBuilder devices(List<Layer2Gateway.Device> devices);

    Layer2GatewayBuilder tenantId(String tenantId);

    Layer2GatewayBuilder id(String id);

    Layer2GatewayBuilder name(String name);
}
