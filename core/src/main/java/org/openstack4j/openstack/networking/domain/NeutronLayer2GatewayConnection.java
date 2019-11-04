package org.openstack4j.openstack.networking.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import org.openstack4j.model.common.builder.ResourceBuilder;
import org.openstack4j.model.network.Layer2GatewayConnection;
import org.openstack4j.model.network.builder.Layer2GatewayConnectionBuilder;
import org.openstack4j.openstack.common.ListResult;

import java.util.List;

public class NeutronLayer2GatewayConnection implements Layer2GatewayConnection {

    private static final long serialVersionUID = 1L;

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("tenant_id")
    private String tenantId;

    @JsonProperty("l2_gateway_id")
    private String gatewayId;

    @JsonProperty("network_id")
    private String networkId;

    @JsonProperty("segmentation_id")
    private String segmentationId;

    public NeutronLayer2GatewayConnection() {
    }

    public NeutronLayer2GatewayConnection(
            String id,
            String name,
            String tenantId,
            String gatewayId,
            String networkId,
            String segmentationId
    ) {
        this.id = id;
        this.name = name;
        this.tenantId = tenantId;
        this.gatewayId = gatewayId;
        this.networkId = networkId;
        this.segmentationId = segmentationId;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getId() {
        return id;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setId(String id) {
        this.id = id;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getTenantId() {
        return tenantId;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    @Override
    public String getGatewayId() {
        return gatewayId;
    }

    @Override
    public void setGatewayId(String gatewayId) {
        this.gatewayId = gatewayId;
    }

    @Override
    public String getNetworkId() {
        return networkId;
    }

    @Override
    public void setNetworkId(String networkId) {
        this.networkId = networkId;
    }

    @Override
    public String getSegmentationId() {
        return segmentationId;
    }

    @Override
    public void setSegmentationId(String segmentationId) {
        this.segmentationId = segmentationId;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).omitNullValues()
                .add("id", id)
                .add("name", name)
                .add("tenantId", tenantId)
                .add("gatewayId", gatewayId)
                .add("networkId", networkId)
                .add("segmentationId", segmentationId)
                .toString();
    }

    @Override
    public Layer2GatewayConnectionBuilder toBuilder() {
        return new Layer2GatewayConnectionConcreteBuilder(this);
    }

    public static class GatewayConnections extends ListResult<NeutronLayer2GatewayConnection> {

        private static final long serialVersionUID = 1L;

        @JsonProperty("l2_gateway_connections")
        private List<NeutronLayer2GatewayConnection> connections;

        @Override
        protected List<NeutronLayer2GatewayConnection> value() {
            return connections;
        }
    }

    public static class Layer2GatewayConnectionConcreteBuilder
            extends ResourceBuilder<Layer2GatewayConnection, Layer2GatewayConnectionConcreteBuilder>
            implements Layer2GatewayConnectionBuilder {
        private NeutronLayer2GatewayConnection m;

        public Layer2GatewayConnectionConcreteBuilder(NeutronLayer2GatewayConnection connection) {
            this.m = connection;
        }

        public Layer2GatewayConnectionConcreteBuilder() {
            this.m = new NeutronLayer2GatewayConnection();
        }

        @Override
        protected NeutronLayer2GatewayConnection reference() {
            return m;
        }

        @Override
        public Layer2GatewayConnection build() {
            return m;
        }

        @Override
        public Layer2GatewayConnectionBuilder from(Layer2GatewayConnection in) {
            m = (NeutronLayer2GatewayConnection) in;
            return this;
        }

        @Override
        public Layer2GatewayConnectionBuilder gatewayId(String gatewayId) {
            m.setGatewayId(gatewayId);
            return this;
        }

        @Override
        public Layer2GatewayConnectionBuilder networkId(String networkId) {
            m.setNetworkId(networkId);
            return this;
        }

        @Override
        public Layer2GatewayConnectionBuilder segmentationId(String segmentationId) {
            m.setSegmentationId(segmentationId);
            return this;
        }
    }
}
