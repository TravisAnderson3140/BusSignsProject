package com.example.bussigns;
import java.util.List;

public class BusResponse {
    private Siri Siri;

    public Siri getSiri() {
        return Siri;
    }

    public void setSiri(Siri siri) {
        Siri = siri;
    }

    public class Siri {
        private ServiceDelivery ServiceDelivery;

        public ServiceDelivery getServiceDelivery() {
            return ServiceDelivery;
        }

        public void setServiceDelivery(ServiceDelivery serviceDelivery) {
            ServiceDelivery = serviceDelivery;
        }
    }

    public class ServiceDelivery {
        private List<StopMonitoringDelivery> StopMonitoringDelivery;

        public List<StopMonitoringDelivery> getStopMonitoringDelivery() {
            return StopMonitoringDelivery;
        }

        public void setStopMonitoringDelivery(List<StopMonitoringDelivery> stopMonitoringDelivery) {
            StopMonitoringDelivery = stopMonitoringDelivery;
        }
    }

    public class StopMonitoringDelivery {
        private List<MonitoredStopVisit> MonitoredStopVisit;

        public List<MonitoredStopVisit> getMonitoredStopVisit() {
            return MonitoredStopVisit;
        }

        public void setMonitoredStopVisit(List<MonitoredStopVisit> monitoredStopVisit) {
            MonitoredStopVisit = monitoredStopVisit;
        }
    }

    public class MonitoredStopVisit {
        private MonitoredVehicleJourney MonitoredVehicleJourney;

        public MonitoredVehicleJourney getMonitoredVehicleJourney() {
            return MonitoredVehicleJourney;
        }

        public void setMonitoredVehicleJourney(MonitoredVehicleJourney monitoredVehicleJourney) {
            MonitoredVehicleJourney = monitoredVehicleJourney;
        }
    }

    public class MonitoredVehicleJourney {
        private String LineRef;

        public String getDirectionRef() {
            return DirectionRef;
        }

        public void setDirectionRef(String directionRef) {
            DirectionRef = directionRef;
        }

        public MonitoredVehicleJourney.FramedVehicleJourneyRef getFramedVehicleJourneyRef() {
            return FramedVehicleJourneyRef;
        }

        public void setFramedVehicleJourneyRef(MonitoredVehicleJourney.FramedVehicleJourneyRef framedVehicleJourneyRef) {
            FramedVehicleJourneyRef = framedVehicleJourneyRef;
        }

        public String getJourneyPatternRef() {
            return JourneyPatternRef;
        }

        public void setJourneyPatternRef(String journeyPatternRef) {
            JourneyPatternRef = journeyPatternRef;
        }

        public String getPublishedLineName() {
            return PublishedLineName;
        }

        public void setPublishedLineName(String publishedLineName) {
            PublishedLineName = publishedLineName;
        }

        public String getOperatorRef() {
            return OperatorRef;
        }

        public void setOperatorRef(String operatorRef) {
            OperatorRef = operatorRef;
        }

        public String getOriginRef() {
            return OriginRef;
        }

        public void setOriginRef(String originRef) {
            OriginRef = originRef;
        }

        public String getDestinationName() {
            return DestinationName;
        }

        public void setDestinationName(String destinationName) {
            DestinationName = destinationName;
        }

        public boolean isMonitored() {
            return Monitored;
        }

        public void setMonitored(boolean monitored) {
            Monitored = monitored;
        }

        public MonitoredVehicleJourney.VehicleLocation getVehicleLocation() {
            return VehicleLocation;
        }

        public void setVehicleLocation(MonitoredVehicleJourney.VehicleLocation vehicleLocation) {
            VehicleLocation = vehicleLocation;
        }

        public double getBearing() {
            return Bearing;
        }

        public void setBearing(double bearing) {
            Bearing = bearing;
        }

        public String getProgressRate() {
            return ProgressRate;
        }

        public void setProgressRate(String progressRate) {
            ProgressRate = progressRate;
        }

        public String getBlockRef() {
            return BlockRef;
        }

        public void setBlockRef(String blockRef) {
            BlockRef = blockRef;
        }

        public String getVehicleRef() {
            return VehicleRef;
        }

        public void setVehicleRef(String vehicleRef) {
            VehicleRef = vehicleRef;
        }

        public MonitoredVehicleJourney.MonitoredCall getMonitoredCall() {
            return MonitoredCall;
        }

        public void setMonitoredCall(MonitoredVehicleJourney.MonitoredCall monitoredCall) {
            MonitoredCall = monitoredCall;
        }

        public String getRecordedAtTime() {
            return RecordedAtTime;
        }

        public void setRecordedAtTime(String recordedAtTime) {
            RecordedAtTime = recordedAtTime;
        }

        private String DirectionRef;
        private FramedVehicleJourneyRef FramedVehicleJourneyRef;
        private String JourneyPatternRef;
        private String PublishedLineName;
        private String OperatorRef;
        private String OriginRef;
        private String DestinationName;
        private boolean Monitored;
        private VehicleLocation VehicleLocation;
        private double Bearing;
        private String ProgressRate;
        private String BlockRef;
        private String VehicleRef;
        private MonitoredCall MonitoredCall;
        private String RecordedAtTime;

        public String getLineRef() {
            return LineRef;
        }

        public void setLineRef(String lineRef) {
            LineRef = lineRef;
        }

        public class FramedVehicleJourneyRef {
            private String DataFrameRef;
            private String DatedVehicleJourneyRef;

            public String getDataFrameRef() {
                return DataFrameRef;
            }

            public void setDataFrameRef(String dataFrameRef) {
                DataFrameRef = dataFrameRef;
            }

            public String getDatedVehicleJourneyRef() {
                return DatedVehicleJourneyRef;
            }

            public void setDatedVehicleJourneyRef(String datedVehicleJourneyRef) {
                DatedVehicleJourneyRef = datedVehicleJourneyRef;
            }
        }

        public class VehicleLocation {
            private double Longitude;
            private double Latitude;

            public double getLongitude() {
                return Longitude;
            }

            public void setLongitude(double longitude) {
                Longitude = longitude;
            }

            public double getLatitude() {
                return Latitude;
            }

            public void setLatitude(double latitude) {
                Latitude = latitude;
            }
        }

        public class MonitoredCall {
            private String AimedArrivalTime;
            private String ExpectedArrivalTime;
            private String AimedDepartureTime;
            private String ExpectedDepartureTime;
            private Extensions Extensions;
            private String StopPointRef;
            private int VisitNumber;
            private String StopPointName;

            public String getAimedArrivalTime() {
                return AimedArrivalTime;
            }

            public void setAimedArrivalTime(String aimedArrivalTime) {
                AimedArrivalTime = aimedArrivalTime;
            }

            public String getExpectedArrivalTime() {
                return ExpectedArrivalTime;
            }

            public void setExpectedArrivalTime(String expectedArrivalTime) {
                ExpectedArrivalTime = expectedArrivalTime;
            }

            public String getAimedDepartureTime() {
                return AimedDepartureTime;
            }

            public void setAimedDepartureTime(String aimedDepartureTime) {
                AimedDepartureTime = aimedDepartureTime;
            }

            public String getExpectedDepartureTime() {
                return ExpectedDepartureTime;
            }

            public void setExpectedDepartureTime(String expectedDepartureTime) {
                ExpectedDepartureTime = expectedDepartureTime;
            }

            public MonitoredVehicleJourney.MonitoredCall.Extensions getExtensions() {
                return Extensions;
            }

            public void setExtensions(MonitoredVehicleJourney.MonitoredCall.Extensions extensions) {
                Extensions = extensions;
            }

            public String getStopPointRef() {
                return StopPointRef;
            }

            public void setStopPointRef(String stopPointRef) {
                StopPointRef = stopPointRef;
            }

            public int getVisitNumber() {
                return VisitNumber;
            }

            public void setVisitNumber(int visitNumber) {
                VisitNumber = visitNumber;
            }

            public String getStopPointName() {
                return StopPointName;
            }

            public void setStopPointName(String stopPointName) {
                StopPointName = stopPointName;
            }

            public class Extensions {
                private Distances Distances;
                private Capacities Capacities;

                public MonitoredVehicleJourney.MonitoredCall.Extensions.Distances getDistances() {
                    return Distances;
                }

                public void setDistances(MonitoredVehicleJourney.MonitoredCall.Extensions.Distances distances) {
                    Distances = distances;
                }

                public MonitoredVehicleJourney.MonitoredCall.Extensions.Capacities getCapacities() {
                    return Capacities;
                }

                public void setCapacities(MonitoredVehicleJourney.MonitoredCall.Extensions.Capacities capacities) {
                    Capacities = capacities;
                }

                public class Distances {
                    private String PresentableDistance;
                    private double DistanceFromCall;
                    private int StopsFromCall;
                    private double CallDistanceAlongRoute;

                    public String getPresentableDistance() {
                        return PresentableDistance;
                    }

                    public void setPresentableDistance(String presentableDistance) {
                        PresentableDistance = presentableDistance;
                    }

                    public double getDistanceFromCall() {
                        return DistanceFromCall;
                    }

                    public void setDistanceFromCall(double distanceFromCall) {
                        DistanceFromCall = distanceFromCall;
                    }

                    public int getStopsFromCall() {
                        return StopsFromCall;
                    }

                    public void setStopsFromCall(int stopsFromCall) {
                        StopsFromCall = stopsFromCall;
                    }

                    public double getCallDistanceAlongRoute() {
                        return CallDistanceAlongRoute;
                    }

                    public void setCallDistanceAlongRoute(double callDistanceAlongRoute) {
                        CallDistanceAlongRoute = callDistanceAlongRoute;
                    }
                }

                public class Capacities {
                    private int EstimatedPassengerCount;
                    private int EstimatedPassengerCapacity;

                    public int getEstimatedPassengerCount() {
                        return EstimatedPassengerCount;
                    }

                    public void setEstimatedPassengerCount(int estimatedPassengerCount) {
                        EstimatedPassengerCount = estimatedPassengerCount;
                    }

                    public int getEstimatedPassengerCapacity() {
                        return EstimatedPassengerCapacity;
                    }

                    public void setEstimatedPassengerCapacity(int estimatedPassengerCapacity) {
                        EstimatedPassengerCapacity = estimatedPassengerCapacity;
                    }
                }
            }
        }
    }
}