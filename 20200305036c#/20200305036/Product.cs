using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _20200305036
{
    internal class Product
    {
        public string ProductName { get; set; }
        public int UnitNumber { get; set; }
        public int SequenceNumber { get; set; }
        public DateTime CountingDateTime { get; set; }
        public string BrandManufacturer { get; set; }

        public string PackageType { get; set; }
        public string WarehouseName { get; set; }

        public string LocationInWarehouse { get; set; }
        public int QuantityAvailable { get; set; }






    }
}