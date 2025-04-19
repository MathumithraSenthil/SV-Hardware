import React, { useEffect, useState } from 'react';
import { Chart as ChartJS, ArcElement, Tooltip, Legend } from 'chart.js';
import { Pie } from 'react-chartjs-2';
import axios from 'axios';

ChartJS.register(ArcElement, Tooltip, Legend);
function PieChartDashboard() {
  const [data, setData] = useState(null);
  const [error, setError] = useState("");
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const fetchCounts = async () => {
      debugger;
      try {
        const dashboardCounts = [
          { key: "cashPayments", url: "http://localhost:9887/dashboard/countCashPaymentMode" },
          { key: "instrumentPayments", url: "http://localhost:9887/dashboard/countInsrtrumentPaymentMode" },
          { key: "upiPayments", url: "http://localhost:9887/dashboard/countUpiPaymentMode" }
        ];

        const responses = await Promise.all(
          dashboardCounts.map(async (endpoint) => {
            const response = await axios.get(endpoint.url);
            console.log(`${endpoint.key}:`, response.data); 
            return { key: endpoint.key, value: response.data.total || response.data };
          })
        );

        const counts = responses.reduce((result, item) => {
          result[item.key] = item.value;
          return result;
        }, {});

        console.log("Final Data:", counts);

        setData({
          labels: ["Cash Payments", "Instrument Payments", "UPI Payments"],
          datasets: [
            {
              label: "Counts",
              data: [
                counts.cashPayments,
                counts.instrumentPayments,
                counts.upiPayments
              ],
              backgroundColor: [
                "rgba(255, 99, 132, 0.2)",
                "rgba(54, 162, 235, 0.2)",
                "rgba(255, 206, 86, 0.2)"
              ],
              borderColor: [
                "rgba(54, 162, 235, 1)",
                "rgba(75, 192, 192, 1)",
                "rgba(153, 102, 255, 1)",
              ],
              borderWidth: 1,
            },
          ],
        });

      } catch (error) {
        console.error("Error fetching counts:", error);
        setError("Failed to load counts.");
      } finally {
        setLoading(false);
      }
    };

    fetchCounts();
  }, []);

  if (loading) return <p>Loading...</p>;
  if (error) return <p>{error}</p>;

  return (
    <div style={{
        display: "block",
        height: "330px",
        width: "417px"
    }}>
        
        <Pie data={data} />
    </div>
  );
}
export default PieChartDashboard