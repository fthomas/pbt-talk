package pbt;

import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Ordering;

import java.util.Objects;

public class Bandwidth implements Comparable<Bandwidth> {
    private Integer downstream;
    private Integer upstream;

    public Bandwidth(Integer downstream, Integer upstream) {
        this.downstream = downstream;
        this.upstream = upstream;
    }

    public Integer getDownstream() {
        return downstream;
    }

    void setDownstream(Integer downstream) {
        this.downstream = downstream;
    }

    public Integer getUpstream() {
        return upstream;
    }

    void setUpstream(Integer upstream) {
        this.upstream = upstream;
    }

    @Override
    public int hashCode() {
        return Objects.hash(downstream, upstream);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Bandwidth other = (Bandwidth) obj;
        return Objects.equals(this.downstream, other.downstream) && Objects.equals(this.upstream, other.upstream);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Bandwidth{");
        sb.append("downstream=").append(downstream);
        sb.append(", upstream=").append(upstream);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int compareTo(Bandwidth other) {
        return ComparisonChain.start()
                .compare(this.downstream, other.downstream, Ordering.natural().nullsLast())
                .compare(this.upstream, other.upstream, Ordering.natural().nullsLast())
                .result();
    }
}
