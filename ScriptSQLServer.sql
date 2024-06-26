USE [master]
GO
/****** Object:  Database [ProyectoCLAPdb]    Script Date: 08/02/2024 13:13:42 ******/
CREATE DATABASE [ProyectoCLAPdb]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'ProyectoCLAPdb', FILENAME = N'C:\SQLData\ProyectoCLAPdb.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'ProyectoCLAPdb_log', FILENAME = N'C:\SQLData\ProyectoCLAPdb_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT, LEDGER = OFF
GO
ALTER DATABASE [ProyectoCLAPdb] SET COMPATIBILITY_LEVEL = 160
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [ProyectoCLAPdb].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [ProyectoCLAPdb] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [ProyectoCLAPdb] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [ProyectoCLAPdb] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [ProyectoCLAPdb] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [ProyectoCLAPdb] SET ARITHABORT OFF 
GO
ALTER DATABASE [ProyectoCLAPdb] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [ProyectoCLAPdb] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [ProyectoCLAPdb] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [ProyectoCLAPdb] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [ProyectoCLAPdb] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [ProyectoCLAPdb] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [ProyectoCLAPdb] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [ProyectoCLAPdb] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [ProyectoCLAPdb] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [ProyectoCLAPdb] SET  DISABLE_BROKER 
GO
ALTER DATABASE [ProyectoCLAPdb] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [ProyectoCLAPdb] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [ProyectoCLAPdb] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [ProyectoCLAPdb] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [ProyectoCLAPdb] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [ProyectoCLAPdb] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [ProyectoCLAPdb] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [ProyectoCLAPdb] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [ProyectoCLAPdb] SET  MULTI_USER 
GO
ALTER DATABASE [ProyectoCLAPdb] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [ProyectoCLAPdb] SET DB_CHAINING OFF 
GO
ALTER DATABASE [ProyectoCLAPdb] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [ProyectoCLAPdb] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [ProyectoCLAPdb] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [ProyectoCLAPdb] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [ProyectoCLAPdb] SET QUERY_STORE = ON
GO
ALTER DATABASE [ProyectoCLAPdb] SET QUERY_STORE (OPERATION_MODE = READ_WRITE, CLEANUP_POLICY = (STALE_QUERY_THRESHOLD_DAYS = 30), DATA_FLUSH_INTERVAL_SECONDS = 900, INTERVAL_LENGTH_MINUTES = 60, MAX_STORAGE_SIZE_MB = 1000, QUERY_CAPTURE_MODE = AUTO, SIZE_BASED_CLEANUP_MODE = AUTO, MAX_PLANS_PER_QUERY = 200, WAIT_STATS_CAPTURE_MODE = ON)
GO
USE [ProyectoCLAPdb]
GO
/****** Object:  Table [dbo].[Presa]    Script Date: 08/02/2024 13:13:43 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Presa](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Nombre] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PresaVia]    Script Date: 08/02/2024 13:13:43 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PresaVia](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[ViaId] [int] NOT NULL,
	[PresaId] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Tiempos]    Script Date: 08/02/2024 13:13:43 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Tiempos](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[UsuarioId] [int] NOT NULL,
	[ViaId] [int] NOT NULL,
	[Tiempo] [time](7) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Usuarios]    Script Date: 08/02/2024 13:13:43 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Usuarios](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Usuario] [nvarchar](50) NOT NULL,
	[Correo] [nvarchar](50) NOT NULL,
	[Contraseña] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[via]    Script Date: 08/02/2024 13:13:43 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[via](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Nombre] [nvarchar](50) NOT NULL,
	[Info] [nvarchar](max) NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ViaZona]    Script Date: 08/02/2024 13:13:43 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ViaZona](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[ZonaId] [int] NOT NULL,
	[ViaId] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Zona]    Script Date: 08/02/2024 13:13:43 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Zona](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Nombre] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Presa] ON 

INSERT [dbo].[Presa] ([Id], [Nombre]) VALUES (1, N'A1')
INSERT [dbo].[Presa] ([Id], [Nombre]) VALUES (2, N'A2')
INSERT [dbo].[Presa] ([Id], [Nombre]) VALUES (3, N'A3')
INSERT [dbo].[Presa] ([Id], [Nombre]) VALUES (4, N'A4')
INSERT [dbo].[Presa] ([Id], [Nombre]) VALUES (5, N'A5')
INSERT [dbo].[Presa] ([Id], [Nombre]) VALUES (6, N'B1')
INSERT [dbo].[Presa] ([Id], [Nombre]) VALUES (7, N'B2')
INSERT [dbo].[Presa] ([Id], [Nombre]) VALUES (8, N'B3')
INSERT [dbo].[Presa] ([Id], [Nombre]) VALUES (9, N'B4')
INSERT [dbo].[Presa] ([Id], [Nombre]) VALUES (10, N'B5')
INSERT [dbo].[Presa] ([Id], [Nombre]) VALUES (11, N'C1')
INSERT [dbo].[Presa] ([Id], [Nombre]) VALUES (12, N'C2')
INSERT [dbo].[Presa] ([Id], [Nombre]) VALUES (13, N'C3')
INSERT [dbo].[Presa] ([Id], [Nombre]) VALUES (14, N'C4')
INSERT [dbo].[Presa] ([Id], [Nombre]) VALUES (15, N'C5')
INSERT [dbo].[Presa] ([Id], [Nombre]) VALUES (16, N'D1')
INSERT [dbo].[Presa] ([Id], [Nombre]) VALUES (17, N'D2')
INSERT [dbo].[Presa] ([Id], [Nombre]) VALUES (18, N'D3')
INSERT [dbo].[Presa] ([Id], [Nombre]) VALUES (19, N'D4')
INSERT [dbo].[Presa] ([Id], [Nombre]) VALUES (20, N'D5')
INSERT [dbo].[Presa] ([Id], [Nombre]) VALUES (21, N'E1')
INSERT [dbo].[Presa] ([Id], [Nombre]) VALUES (22, N'E2')
INSERT [dbo].[Presa] ([Id], [Nombre]) VALUES (23, N'E3')
INSERT [dbo].[Presa] ([Id], [Nombre]) VALUES (24, N'E4')
INSERT [dbo].[Presa] ([Id], [Nombre]) VALUES (25, N'E5')
INSERT [dbo].[Presa] ([Id], [Nombre]) VALUES (26, N'F1')
INSERT [dbo].[Presa] ([Id], [Nombre]) VALUES (27, N'F2')
INSERT [dbo].[Presa] ([Id], [Nombre]) VALUES (28, N'F3')
INSERT [dbo].[Presa] ([Id], [Nombre]) VALUES (29, N'F4')
INSERT [dbo].[Presa] ([Id], [Nombre]) VALUES (30, N'F5')
INSERT [dbo].[Presa] ([Id], [Nombre]) VALUES (31, N'G1')
INSERT [dbo].[Presa] ([Id], [Nombre]) VALUES (32, N'G2')
INSERT [dbo].[Presa] ([Id], [Nombre]) VALUES (33, N'G3')
INSERT [dbo].[Presa] ([Id], [Nombre]) VALUES (34, N'G4')
INSERT [dbo].[Presa] ([Id], [Nombre]) VALUES (35, N'G5')
INSERT [dbo].[Presa] ([Id], [Nombre]) VALUES (36, N'H1')
INSERT [dbo].[Presa] ([Id], [Nombre]) VALUES (37, N'H2')
INSERT [dbo].[Presa] ([Id], [Nombre]) VALUES (38, N'H3')
INSERT [dbo].[Presa] ([Id], [Nombre]) VALUES (39, N'H4')
INSERT [dbo].[Presa] ([Id], [Nombre]) VALUES (40, N'H5')
INSERT [dbo].[Presa] ([Id], [Nombre]) VALUES (41, N'I1')
INSERT [dbo].[Presa] ([Id], [Nombre]) VALUES (42, N'I2')
INSERT [dbo].[Presa] ([Id], [Nombre]) VALUES (43, N'I3')
INSERT [dbo].[Presa] ([Id], [Nombre]) VALUES (44, N'I4')
INSERT [dbo].[Presa] ([Id], [Nombre]) VALUES (45, N'I5')
SET IDENTITY_INSERT [dbo].[Presa] OFF
GO
SET IDENTITY_INSERT [dbo].[PresaVia] ON 

INSERT [dbo].[PresaVia] ([Id], [ViaId], [PresaId]) VALUES (1, 1, 1)
INSERT [dbo].[PresaVia] ([Id], [ViaId], [PresaId]) VALUES (3, 1, 2)
INSERT [dbo].[PresaVia] ([Id], [ViaId], [PresaId]) VALUES (4, 1, 3)
INSERT [dbo].[PresaVia] ([Id], [ViaId], [PresaId]) VALUES (6, 1, 4)
INSERT [dbo].[PresaVia] ([Id], [ViaId], [PresaId]) VALUES (7, 1, 5)
INSERT [dbo].[PresaVia] ([Id], [ViaId], [PresaId]) VALUES (8, 2, 6)
INSERT [dbo].[PresaVia] ([Id], [ViaId], [PresaId]) VALUES (9, 2, 7)
INSERT [dbo].[PresaVia] ([Id], [ViaId], [PresaId]) VALUES (10, 2, 8)
INSERT [dbo].[PresaVia] ([Id], [ViaId], [PresaId]) VALUES (11, 2, 9)
INSERT [dbo].[PresaVia] ([Id], [ViaId], [PresaId]) VALUES (12, 2, 10)
INSERT [dbo].[PresaVia] ([Id], [ViaId], [PresaId]) VALUES (13, 3, 11)
INSERT [dbo].[PresaVia] ([Id], [ViaId], [PresaId]) VALUES (14, 3, 12)
INSERT [dbo].[PresaVia] ([Id], [ViaId], [PresaId]) VALUES (15, 3, 13)
INSERT [dbo].[PresaVia] ([Id], [ViaId], [PresaId]) VALUES (16, 3, 14)
INSERT [dbo].[PresaVia] ([Id], [ViaId], [PresaId]) VALUES (17, 3, 15)
INSERT [dbo].[PresaVia] ([Id], [ViaId], [PresaId]) VALUES (18, 4, 16)
INSERT [dbo].[PresaVia] ([Id], [ViaId], [PresaId]) VALUES (19, 4, 17)
INSERT [dbo].[PresaVia] ([Id], [ViaId], [PresaId]) VALUES (20, 4, 18)
INSERT [dbo].[PresaVia] ([Id], [ViaId], [PresaId]) VALUES (21, 4, 19)
INSERT [dbo].[PresaVia] ([Id], [ViaId], [PresaId]) VALUES (22, 4, 20)
INSERT [dbo].[PresaVia] ([Id], [ViaId], [PresaId]) VALUES (23, 5, 21)
INSERT [dbo].[PresaVia] ([Id], [ViaId], [PresaId]) VALUES (24, 5, 22)
INSERT [dbo].[PresaVia] ([Id], [ViaId], [PresaId]) VALUES (25, 5, 23)
INSERT [dbo].[PresaVia] ([Id], [ViaId], [PresaId]) VALUES (26, 5, 24)
INSERT [dbo].[PresaVia] ([Id], [ViaId], [PresaId]) VALUES (27, 5, 25)
INSERT [dbo].[PresaVia] ([Id], [ViaId], [PresaId]) VALUES (28, 6, 26)
INSERT [dbo].[PresaVia] ([Id], [ViaId], [PresaId]) VALUES (31, 6, 27)
INSERT [dbo].[PresaVia] ([Id], [ViaId], [PresaId]) VALUES (32, 6, 28)
INSERT [dbo].[PresaVia] ([Id], [ViaId], [PresaId]) VALUES (33, 6, 29)
INSERT [dbo].[PresaVia] ([Id], [ViaId], [PresaId]) VALUES (34, 6, 30)
INSERT [dbo].[PresaVia] ([Id], [ViaId], [PresaId]) VALUES (35, 7, 31)
INSERT [dbo].[PresaVia] ([Id], [ViaId], [PresaId]) VALUES (36, 7, 32)
INSERT [dbo].[PresaVia] ([Id], [ViaId], [PresaId]) VALUES (37, 7, 33)
INSERT [dbo].[PresaVia] ([Id], [ViaId], [PresaId]) VALUES (38, 7, 34)
INSERT [dbo].[PresaVia] ([Id], [ViaId], [PresaId]) VALUES (39, 7, 35)
INSERT [dbo].[PresaVia] ([Id], [ViaId], [PresaId]) VALUES (40, 8, 36)
INSERT [dbo].[PresaVia] ([Id], [ViaId], [PresaId]) VALUES (41, 8, 37)
INSERT [dbo].[PresaVia] ([Id], [ViaId], [PresaId]) VALUES (42, 8, 38)
INSERT [dbo].[PresaVia] ([Id], [ViaId], [PresaId]) VALUES (43, 8, 39)
INSERT [dbo].[PresaVia] ([Id], [ViaId], [PresaId]) VALUES (44, 8, 40)
INSERT [dbo].[PresaVia] ([Id], [ViaId], [PresaId]) VALUES (86, 9, 41)
INSERT [dbo].[PresaVia] ([Id], [ViaId], [PresaId]) VALUES (87, 9, 42)
INSERT [dbo].[PresaVia] ([Id], [ViaId], [PresaId]) VALUES (88, 9, 43)
INSERT [dbo].[PresaVia] ([Id], [ViaId], [PresaId]) VALUES (89, 9, 44)
INSERT [dbo].[PresaVia] ([Id], [ViaId], [PresaId]) VALUES (90, 9, 45)
SET IDENTITY_INSERT [dbo].[PresaVia] OFF
GO
SET IDENTITY_INSERT [dbo].[Tiempos] ON 

INSERT [dbo].[Tiempos] ([Id], [UsuarioId], [ViaId], [Tiempo]) VALUES (1, 1, 1, CAST(N'00:01:38' AS Time))
INSERT [dbo].[Tiempos] ([Id], [UsuarioId], [ViaId], [Tiempo]) VALUES (2, 2, 1, CAST(N'00:01:45' AS Time))
INSERT [dbo].[Tiempos] ([Id], [UsuarioId], [ViaId], [Tiempo]) VALUES (3, 1, 2, CAST(N'00:01:03' AS Time))
INSERT [dbo].[Tiempos] ([Id], [UsuarioId], [ViaId], [Tiempo]) VALUES (4, 2, 2, CAST(N'00:00:51' AS Time))
INSERT [dbo].[Tiempos] ([Id], [UsuarioId], [ViaId], [Tiempo]) VALUES (5, 7, 1, CAST(N'00:01:20' AS Time))
SET IDENTITY_INSERT [dbo].[Tiempos] OFF
GO
SET IDENTITY_INSERT [dbo].[Usuarios] ON 

INSERT [dbo].[Usuarios] ([Id], [Usuario], [Correo], [Contraseña]) VALUES (1, N'IsmaelS', N'IsmaelS@gmail.com', N'12345')
INSERT [dbo].[Usuarios] ([Id], [Usuario], [Correo], [Contraseña]) VALUES (2, N'BelenC', N'BelenC@gmail.com', N'54321')
INSERT [dbo].[Usuarios] ([Id], [Usuario], [Correo], [Contraseña]) VALUES (7, N'FranA', N'FranA@gmail.com', N'12345')
INSERT [dbo].[Usuarios] ([Id], [Usuario], [Correo], [Contraseña]) VALUES (8, N'MateoG', N'MateoG@gmail.com', N'12345')
INSERT [dbo].[Usuarios] ([Id], [Usuario], [Correo], [Contraseña]) VALUES (9, N'PacoS', N'PacoS@gmail.com', N'123456')
SET IDENTITY_INSERT [dbo].[Usuarios] OFF
GO
SET IDENTITY_INSERT [dbo].[via] ON 

INSERT [dbo].[via] ([Id], [Nombre], [Info]) VALUES (1, N'Velocidad1', N'Muy muy muy buena.')
INSERT [dbo].[via] ([Id], [Nombre], [Info]) VALUES (2, N'Velocidad2', NULL)
INSERT [dbo].[via] ([Id], [Nombre], [Info]) VALUES (3, N'Velocidad3', NULL)
INSERT [dbo].[via] ([Id], [Nombre], [Info]) VALUES (4, N'Desplome1', NULL)
INSERT [dbo].[via] ([Id], [Nombre], [Info]) VALUES (5, N'Desplome2', NULL)
INSERT [dbo].[via] ([Id], [Nombre], [Info]) VALUES (6, N'Desplome3', NULL)
INSERT [dbo].[via] ([Id], [Nombre], [Info]) VALUES (7, N'Equilibrio1', NULL)
INSERT [dbo].[via] ([Id], [Nombre], [Info]) VALUES (8, N'Equilibrio2', NULL)
INSERT [dbo].[via] ([Id], [Nombre], [Info]) VALUES (9, N'Equilibrio3', NULL)
SET IDENTITY_INSERT [dbo].[via] OFF
GO
SET IDENTITY_INSERT [dbo].[ViaZona] ON 

INSERT [dbo].[ViaZona] ([Id], [ZonaId], [ViaId]) VALUES (1, 1, 1)
INSERT [dbo].[ViaZona] ([Id], [ZonaId], [ViaId]) VALUES (2, 1, 2)
INSERT [dbo].[ViaZona] ([Id], [ZonaId], [ViaId]) VALUES (3, 2, 3)
INSERT [dbo].[ViaZona] ([Id], [ZonaId], [ViaId]) VALUES (4, 3, 4)
INSERT [dbo].[ViaZona] ([Id], [ZonaId], [ViaId]) VALUES (5, 3, 5)
INSERT [dbo].[ViaZona] ([Id], [ZonaId], [ViaId]) VALUES (6, 4, 6)
INSERT [dbo].[ViaZona] ([Id], [ZonaId], [ViaId]) VALUES (7, 5, 7)
INSERT [dbo].[ViaZona] ([Id], [ZonaId], [ViaId]) VALUES (10, 5, 8)
INSERT [dbo].[ViaZona] ([Id], [ZonaId], [ViaId]) VALUES (11, 5, 9)
SET IDENTITY_INSERT [dbo].[ViaZona] OFF
GO
SET IDENTITY_INSERT [dbo].[Zona] ON 

INSERT [dbo].[Zona] ([Id], [Nombre]) VALUES (1, N'Izquierda')
INSERT [dbo].[Zona] ([Id], [Nombre]) VALUES (2, N'Fondo izquierda')
INSERT [dbo].[Zona] ([Id], [Nombre]) VALUES (3, N'Columna')
INSERT [dbo].[Zona] ([Id], [Nombre]) VALUES (4, N'Fondo derecha')
INSERT [dbo].[Zona] ([Id], [Nombre]) VALUES (5, N'Derecha')
SET IDENTITY_INSERT [dbo].[Zona] OFF
GO
ALTER TABLE [dbo].[PresaVia]  WITH CHECK ADD  CONSTRAINT [PresaCE] FOREIGN KEY([PresaId])
REFERENCES [dbo].[Presa] ([Id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[PresaVia] CHECK CONSTRAINT [PresaCE]
GO
ALTER TABLE [dbo].[PresaVia]  WITH CHECK ADD  CONSTRAINT [ViaCE] FOREIGN KEY([ViaId])
REFERENCES [dbo].[via] ([Id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[PresaVia] CHECK CONSTRAINT [ViaCE]
GO
ALTER TABLE [dbo].[Tiempos]  WITH CHECK ADD  CONSTRAINT [UsuarioCE] FOREIGN KEY([UsuarioId])
REFERENCES [dbo].[Usuarios] ([Id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Tiempos] CHECK CONSTRAINT [UsuarioCE]
GO
ALTER TABLE [dbo].[Tiempos]  WITH CHECK ADD  CONSTRAINT [Via3CE] FOREIGN KEY([ViaId])
REFERENCES [dbo].[via] ([Id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Tiempos] CHECK CONSTRAINT [Via3CE]
GO
ALTER TABLE [dbo].[ViaZona]  WITH CHECK ADD  CONSTRAINT [Via2CE] FOREIGN KEY([ViaId])
REFERENCES [dbo].[via] ([Id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[ViaZona] CHECK CONSTRAINT [Via2CE]
GO
ALTER TABLE [dbo].[ViaZona]  WITH CHECK ADD  CONSTRAINT [ZonaCE] FOREIGN KEY([ZonaId])
REFERENCES [dbo].[Zona] ([Id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[ViaZona] CHECK CONSTRAINT [ZonaCE]
GO
USE [master]
GO
ALTER DATABASE [ProyectoCLAPdb] SET  READ_WRITE 
GO
