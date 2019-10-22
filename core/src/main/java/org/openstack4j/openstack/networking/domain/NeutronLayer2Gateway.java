package org.openstack4j.openstack.networking.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import org.openstack4j.model.common.builder.ResourceBuilder;
import org.openstack4j.model.network.Layer2Gateway;
import org.openstack4j.model.network.builder.Layer2GatewayBuilder;
import org.openstack4j.openstack.common.ListResult;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class NeutronLayer2Gateway implements Layer2Gateway {

    private static final long serialVersionUID = 1L;

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("tenant_id")
    private String tenantId;

    @JsonProperty("devices")
    private List<Device> devices;

    public NeutronLayer2Gateway() { }

    public NeutronLayer2Gateway(String id, String name, String tenantId, List<Device> devices) {
        this.id = id;
        this.name = name;
        this.tenantId = tenantId;
        this.devices = devices;
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

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Device> getDevices() {
        return devices;
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
                .add("devices", devices)
                .toString();
    }

    @Override
    public Layer2GatewayBuilder toBuilder() {
        return new Layer2GatewayConcreteBuilder(this);
    }

    public static class Gateways extends ListResult<NeutronLayer2Gateway> {

        private static final long serialVersionUID = 1L;

        @JsonProperty("gateways")
        private List<NeutronLayer2Gateway> gateways;

        @Override
        protected List<NeutronLayer2Gateway> value() {
            return gateways;
        }
    }

    public static class DeviceImpl implements Device {

        public DeviceImpl(){}

        @JsonCreator
        public DeviceImpl(
                @JsonProperty("interface_names") String interfaceNames,
                @JsonProperty("name") String deviceName
        ) {
            this.deviceName = deviceName;
            if (interfaceNames != null) {
                this.interfaces = Arrays.stream(interfaceNames.split(";"))
                        .map(InterfaceImpl::new).collect(Collectors.toList());
            }
        }

        @JsonProperty("interfaces")
        private List<Interface> interfaces;

        @JsonProperty("device_name")
        private String deviceName;

        /**
         * {@inheritDoc}
         */
        @Override
        public String getDeviceName() {
            return deviceName;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public List<Interface> getInterfaces() {
            return interfaces;
        }
    }

    public static class InterfaceImpl implements Device.Interface {

        @JsonProperty("name")
        private String name;
        @JsonProperty("segmentation_id")
        private List<String> segmentationId;

        public InterfaceImpl(){}

        public InterfaceImpl(String interfaceName) {
            if (interfaceName.contains("|")) {
                this.name = interfaceName.split("\\|")[0];
                this.segmentationId = Arrays.asList(interfaceName.split("\\|")[1].split("#"));
            } else {
                this.name = interfaceName;
            }
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
        public List<String> getSegmentationId() {
            return segmentationId;
        }
    }

    public static class Layer2GatewayConcreteBuilder extends ResourceBuilder<Layer2Gateway, Layer2GatewayConcreteBuilder> implements Layer2GatewayBuilder {
        private NeutronLayer2Gateway m;

        public Layer2GatewayConcreteBuilder(NeutronLayer2Gateway policy) {
            this.m = policy;
        }

        public Layer2GatewayConcreteBuilder() {
            this.m = new NeutronLayer2Gateway();
        }

        @Override
        protected NeutronLayer2Gateway reference() {
            return m;
        }

        @Override
        public Layer2Gateway build() {
            return m;
        }

        @Override
        public Layer2GatewayBuilder from(Layer2Gateway in) {
            m = (NeutronLayer2Gateway) in;
            return this;
        }

        @Override
        public Layer2GatewayBuilder devices(List<Device> devices) {
            m.devices = devices;
            return this;
        }
    }
}
