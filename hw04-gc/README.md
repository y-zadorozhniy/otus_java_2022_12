# Garbage Collector

<table>
   <thead>
      <tr>
         <th>ID теста</th>
         <th>GC</th>
         <th>Heap Size</th>
         <th>Time (ms)</th>
      </tr>
   </thead>
   <tbody>
<tr><th colspan="4">До оптимизации кода</th></tr>
      <tr>
         <td>1</td>
         <td>G1</td>
         <td>-Xms256m -Xmx256m</td>
         <td>OOM</td>
      </tr>
      <tr>
         <td>2</td>
         <td>G1</td>
         <td>-Xms2G -Xmx2G</td>
         <td>9292</td>
      </tr>
      <tr>
         <td>3</td>
         <td>G1</td>
         <td>-Xms1024m -Xmx1024m</td>
         <td>9868</td>
      </tr>
      <tr>
         <td>4</td>
         <td>G1</td>
         <td>-Xms1697m -Xmx1697m</td>
         <td>8688</td>
      </tr>
      <tr>
         <td>5</td>
         <td>G1</td>
         <td>-Xms1500m -Xmx1500m</td>
         <td>8688</td>
      </tr>
      <tr>
         <td>6</td>
         <td>Serial</td>
         <td>-Xms1697m -Xmx1697m</td>
         <td>8852</td>
      </tr>
      <tr>
         <td>7</td>
         <td>Parallel</td>
         <td>-Xms1697m -Xmx1697m</td>
         <td>16818</td>
      </tr>
      <tr>
         <td>8</td>
         <td>Parallel</td>
         <td>-Xms4G -Xmx4G</td>
         <td>7521</td>
      </tr>
      <tr>
         <td>9</td>
         <td>Epsilon</td>
         <td>-Xms8G -Xmx16G</td>
         <td>6272</td>
      </tr>
      <tr>
         <td>10</td>
         <td>Shenadoah</td>
         <td>-Xms1697m -Xmx1697m</td>
         <td>7150</td>
      </tr>
      <tr>
         <td>11</td>
         <td>Shenadoah</td>
         <td>-Xms512m -Xmx1024m</td>
         <td>14224</td>
      </tr>
      <tr>
         <td>12</td>
         <td>ZGC</td>
         <td>-Xms1697m -Xmx1697m</td>
         <td>4314</td>
      </tr>
      <tr>
         <td>13</td>
         <td>ZGC</td>
         <td>-Xms1024m -Xmx1024m</td>
         <td>5640</td>
      </tr>
      <tr>
         <td>14</td>
         <td>ZGC</td>
         <td>-Xms2G -Xmx2G</td>
         <td>4197</td>
      </tr>
    <tr><th colspan="4">После оптимизации кода</th></tr>
      <tr>
         <td>1</td>
         <td>ZGC</td>
         <td>-Xms64m -Xmx64m</td>
         <td>609</td>
      </tr>
      <tr>
         <td>2</td>
         <td>ZGC</td>
         <td>-Xms2G -Xmx2G</td>
         <td>604</td>
      </tr>
      <tr>
         <td>3</td>
         <td>ZGC</td>
         <td>-Xms256m -Xmx256m</td>
         <td>612</td>
      </tr>
      <tr>
         <td>4</td>
         <td>G1</td>
         <td>-Xms2G -Xmx2G</td>
         <td>612</td>
      </tr>
      <tr>
         <td>5</td>
         <td>G1</td>
         <td>-Xms256m -Xmx256m</td>
         <td>614</td>
      </tr>
      <tr>
         <td>6</td>
         <td>G1</td>
         <td>-Xms64m -Xmx64m</td>
         <td>617</td>
      </tr>
      <tr>
         <td>7</td>
         <td>Serial</td>
         <td>-Xms64m -Xmx64m</td>
         <td>621</td>
      </tr>
   </tbody>
</table>
