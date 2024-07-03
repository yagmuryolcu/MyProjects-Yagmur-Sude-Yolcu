


using System;
using System.Collections.Generic;
using System.Linq;
using System.IO;

using System.Text.Json;
using _20200305036;


namespace firstexercise
{
    internal class Program
    {
        // stockList'i yönetmek için statik bir sınıf 
        internal static class StockManager
        {
            // Bellekte saklanacak statik stockList özelliği
            public static List<Product> stockList = new List<Product>
            {
            new Product
            {
                ProductName = "Laptop",
                UnitNumber = 1001,
                SequenceNumber = 101,
                CountingDateTime = DateTime.Now,
                BrandManufacturer = "Dell",
                PackageType = "Box",
                WarehouseName = "Warehouse A",
                LocationInWarehouse = "A-101",
                QuantityAvailable = 50
            },
            new Product
            {
                ProductName = "Smartphone",
                UnitNumber = 1002,
                SequenceNumber = 102,
                CountingDateTime = DateTime.Now,
                BrandManufacturer = "Samsung",
                PackageType = "Package",
                WarehouseName = "Warehouse B",
                LocationInWarehouse = "B-202",
                QuantityAvailable = 30
            },
            new Product
            {
                ProductName = "Coffee Maker",
                UnitNumber = 1003,
                SequenceNumber = 103,
                CountingDateTime = DateTime.Now,
                BrandManufacturer = "Keurig",
                PackageType = "Carton",
                WarehouseName = "Warehouse A",
                LocationInWarehouse = "A-102",
                QuantityAvailable = 15
            }
        };
            private static int quantityAvailable;
            private static int unitNumber;
            private static int quantityToAdd;

            static void Main(string[] args)
            {
                LoadDataFromJson();


                while (true)
                {
                    Console.WriteLine("1. Add Product");
                    Console.WriteLine("2. List Products");
                    Console.WriteLine("3. Edit Product");
                    Console.WriteLine("4. Delete Product");
                    Console.WriteLine("5. Search Product");
                    Console.WriteLine("6. Sort Products");
                    Console.WriteLine("7. Exit");

                    Console.Write("Enter Your choice (1-7): ");
                    string choice = Console.ReadLine();

                    switch (choice)
                    {
                        case "1":
                            AddProduct();
                            break;
                        case "2":
                            ListProducts();
                            break;
                        case "3":
                            EditProduct();
                            break;
                        case "4":
                            DeleteProduct();
                            break;
                        case "5":
                            SearchProduct();
                            break;
                        case "6":
                            SortProducts();
                            break;
                        case "7":
                            SaveDataToJson(); // Program kapatılmadan önce JSON'a verileri kaydedecek

                            Environment.Exit(0);
                            break;
                        default:
                            Console.WriteLine("Invalid Choice. Please enter a number between 1-7");
                            break;
                    }
                }
            }
            static void LoadDataFromJson()
            {
                try
                {
                    string jsonData = File.ReadAllText("stockData.json");
                    stockList = JsonSerializer.Deserialize<List<Product>>(jsonData);
                }
                catch (FileNotFoundException)
                {
                    Console.WriteLine("JSON file not found. Creating a new list.");
                }
            }

            static void SaveDataToJson()
            {
                string jsonData = JsonSerializer.Serialize(stockList, new JsonSerializerOptions { WriteIndented = true });
                File.WriteAllText("stockData.json", jsonData);
            }

            static void AddProduct()
            {
                Console.Write("Product Name: ");
                string productName = Console.ReadLine();

                Product existingProduct = stockList.Find(p => p.ProductName.Equals(productName, StringComparison.OrdinalIgnoreCase));

                if (existingProduct != null)
                {
                    Console.WriteLine($"Product with name '{productName}' already exists. Updating quantity.");

                    Console.Write("Enter quantity to add: ");
                    while (!int.TryParse(Console.ReadLine(), out int quantityToAdd))
                    {
                        Console.WriteLine("Invalid input. Please enter a valid quantity.");
                    }

                    existingProduct.QuantityAvailable += quantityToAdd;

                    Console.WriteLine($"Quantity added to existing product '{productName}'. Total quantity: {existingProduct.QuantityAvailable}");
                }
                else
                {
                    Product newProduct = new Product();

                    newProduct.ProductName = productName;

                    Console.Write("Unit Number: ");
                    while (!int.TryParse(Console.ReadLine(), out int unitNumber))
                    {
                        Console.WriteLine("Invalid input. Please enter a valid unit number.");
                    }
                    newProduct.UnitNumber = unitNumber;

                    Console.Write("Sequence Number: ");
                    newProduct.SequenceNumber = int.Parse(Console.ReadLine());

                    Console.Write("Counting Date and Time (YYYY-MM-DD HH:mm): ");
                    newProduct.CountingDateTime = DateTime.Parse(Console.ReadLine());

                    Console.Write("Brand/Manufacturer: ");
                    newProduct.BrandManufacturer = Console.ReadLine();

                    Console.Write("Package Type: ");
                    newProduct.PackageType = Console.ReadLine();

                    Console.Write("Warehouse Name: ");
                    newProduct.WarehouseName = Console.ReadLine();

                    Console.Write("Location in the Warehouse: ");
                    newProduct.LocationInWarehouse = Console.ReadLine();

                    Console.Write("Quantity Available: ");
                    if (int.TryParse(Console.ReadLine(), out int quantityAvailable))
                    {
                        newProduct.QuantityAvailable = quantityAvailable;
                        stockList.Add(newProduct);
                        Console.WriteLine("New product added successfully.");
                    }
                    else
                    {
                        Console.WriteLine("Invalid input. Please enter a valid quantity.");
                    }
                }
            }
            static void ListProducts()
            {
                if (stockList.Count == 0)
                {
                    Console.WriteLine("No products in the stock list.");
                }
                else
                {
                    Console.WriteLine("Stock List : ");
                    foreach (var product in stockList)
                    {
                        Console.WriteLine($"Product Name: {product.ProductName}, Unit Number: {product.UnitNumber}, " +
                                          $"Sequence Number: {product.SequenceNumber}, Counting Date and Time: {product.CountingDateTime}, " +
                                          $"Brand/Manufacturer: {product.BrandManufacturer}, Package Type: {product.PackageType}, " +
                                          $"Warehouse Name: {product.WarehouseName}, Location in the Warehouse: {product.LocationInWarehouse}, " +
                                          $"Quantity Available: {product.QuantityAvailable}" + Environment.NewLine + Environment.NewLine);
                    }
                }
            }

            static void EditProduct()
            {
                Console.Write("Enter the Product name to edit: ");
                string productName = Console.ReadLine();
                Product productToEdit = stockList.Find(p => p.ProductName.Equals(productName, StringComparison.OrdinalIgnoreCase));

                if (productToEdit != null)
                {
                    Console.Write("Enter updated Unit Number: ");
                    int updatedUnitNumber;
                    while (!int.TryParse(Console.ReadLine(), out updatedUnitNumber))
                    {
                        Console.WriteLine("Invalid input. Please enter a valid unit number.");
                    }

                    productToEdit.UnitNumber = updatedUnitNumber;
                    Console.WriteLine("Product updated successfully.");
                }
                else
                {
                    Console.WriteLine($"Product with name '{productName}' not found.");
                }
            }

            static void DeleteProduct()
            {
                Console.Write("Enter the product name to delete: ");
                string productName = Console.ReadLine();
                Product productToDelete = stockList.Find(p => p.ProductName.Equals(productName, StringComparison.OrdinalIgnoreCase));

                if (productToDelete != null)
                {
                    stockList.Remove(productToDelete);
                    Console.WriteLine("Product deleted successfully.");
                }
                else
                {
                    Console.WriteLine($"Product with name '{productName}' not found.");
                }
            }

            static void SearchProduct()
            {
                Console.Write("Enter the product name to search: ");
                string productName = Console.ReadLine();
                Product foundProduct = stockList.Find(p => p.ProductName.Equals(productName, StringComparison.OrdinalIgnoreCase));

                if (foundProduct != null)
                {
                    Console.WriteLine($"Product found - Product Name: {foundProduct.ProductName}, " +
                                      $"Unit Number: {foundProduct.UnitNumber}, Sequence Number: {foundProduct.SequenceNumber}, " +
                                      $"Counting Date and Time: {foundProduct.CountingDateTime}, " +
                                      $"Brand/Manufacturer: {foundProduct.BrandManufacturer}, Package Type: {foundProduct.PackageType}, " +
                                      $"Warehouse Name: {foundProduct.WarehouseName}, " +
                                      $"Location in the Warehouse: {foundProduct.LocationInWarehouse}, " +
                                      $"Quantity Available: {foundProduct.QuantityAvailable}");
                }
                else
                {
                    Console.WriteLine($"Product with name '{productName}' not found.");
                }
            }

            static void SortProducts()
            {
                Console.WriteLine("Sort by: 1. Product Name, 2. Unit Number");
                Console.Write("Enter your choice (1 or 2): ");
                string sortChoice = Console.ReadLine();

                switch (sortChoice)
                {
                    case "1":
                        stockList = stockList.OrderBy(p => p.ProductName, StringComparer.OrdinalIgnoreCase).ToList();
                        Console.WriteLine("Products sorted by Product Name.");
                        break;

                    case "2":
                        stockList = stockList.OrderBy(p => p.UnitNumber).ToList();
                        Console.WriteLine("Products sorted by Unit Number.");
                        break;

                    default:
                        Console.WriteLine($"Invalid choice: {sortChoice}. Sorting by Product Name by default.");
                        stockList = stockList.OrderBy(p => p.ProductName, StringComparer.OrdinalIgnoreCase).ToList();
                        break;
                }

                ListProducts();

            }
        }
    }
}



